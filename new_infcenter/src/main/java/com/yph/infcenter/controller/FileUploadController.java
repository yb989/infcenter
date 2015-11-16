package com.yph.infcenter.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.infcenter.service.InfcenterHttpClientService;
import com.yipuhui.infcenter.service.impl.InfcenterHttpClientServiceImpl;
import com.yph.infcenter.common.util.DeleteFileThreadUtil;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController extends BaseController{
	
	private final Lock lock = new ReentrantLock();
	
	
	/**
	 * 
	 * Description:获取文件名称,指定存放路径
	 *
	 * @param 
	 * @return Map<String,Object>
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-25 下午05:29:31
	 */
	@RequestMapping(value = "/toFileUpload")
	public void toFileUpload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,Object> reMap = new HashMap<String,Object>();
		reMap.put("code", "9999");
		
		//验证文件是否上传文件
		if (!file.isEmpty()) {
			//获取文件目标地址
			String path=request.getSession().getServletContext().getRealPath("upload/img");
			try {
				//velidate file is exit
				if(!new File(path).exists()){
					new File(path).mkdirs();
				}
				String filePath = path + "\\" + file.getOriginalFilename();
				//生成文件
				File file1 = new File(filePath);
				file.getFileItem().write(file1);
				//调用文件系统，进行文件传输
				InfcenterHttpClientService service = InfcenterHttpClientServiceImpl.getInstance();
				JSONObject noticeStr = service.doPostFileUpload(file1);
				
				if("0000".equals(noticeStr.get("code"))){
					noticeStr = JSONObject.parseObject(noticeStr.get("data").toString());
					if("1".equals(noticeStr.get("status"))){
						reMap.put("code", "0000");
						reMap.put("filename", noticeStr.get("filename"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DeleteFileThreadUtil util = new DeleteFileThreadUtil(path);
				try {
					lock.lock();
					Thread thread = new Thread(util);
					thread.start();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
		response.getWriter().write(JSON.toJSONString(reMap));
	} 
}

