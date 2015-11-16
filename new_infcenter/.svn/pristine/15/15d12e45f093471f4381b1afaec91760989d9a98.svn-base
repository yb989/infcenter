/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterVelocityServiceImpl 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-12-15
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yph.infcenter.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.yph.infcenter.common.constant.Constants;
import com.yph.infcenter.service.InfcenterVelocityService;
import com.yph.toolcenter.util.StringUtil;

/** 
 *
 * Description: TODO
 *
 * @author DYP
 * @version 1.0
 * <pre>
 * Modification History: 
 *          Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-15 下午03:16:33 DYP         1.0        1.0 Version 
 * </pre>
 */
@Service("infcenterVelocityService")
public class InfcenterVelocityServiceImpl implements InfcenterVelocityService {
	
	@Autowired // spring配置中定义
	private VelocityEngine velocityEngine;
	
	/* (非 Javadoc)
	
	 * <p>Title: createVelocityForHtml</p>
	 * <p>Description: TODO</p>
	 * @param savePath
	 * @param fileName
	 * @param modelName
	 * @param map
	 * @return
	 * @see com.yph.infcenter.service.impl.InfcenterVelocityService#createVelocityForHtml(java.lang.String, java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> createVelocityForHtml(String savePath,
			String fileName, String modelName, Map<String, Object> content) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", "9999");
		try {
			//获取文件内容
			Map<String,Object> veCode = showVelocityForHtml(modelName,content);
			if(veCode.get("code") != null && StringUtil.isNotBlank(veCode.get("code").toString()) && "0000".equals(veCode.get("code"))){
				File file = new File(savePath);
				if(!file.exists()){
					file.mkdirs();
				}
				file = new File(savePath,fileName);
				OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(file),"UTF-8"); 
				BufferedWriter bw = new BufferedWriter(os);
				bw.write(veCode.get("html") == null ? "" : veCode.get("html").toString());
				map.put("code", "0000");
				
				bw.close();
				os.close();
			}
		}  catch (Exception e) {
			e.printStackTrace();
			map.put("code", "9999");
			return map;
		}
		return map;
	}
	
	/*
	 * (非 Javadoc)
	
	 * <p>Title: showVelocityForHtml</p>
	 * <p>Description: TODO</p>
	 * @param modelName
	 * @param content
	 * @return
	 * @see com.yph.infcenter.service.InfcenterVelocityService#showVelocityForHtml(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String,Object> showVelocityForHtml(String modelName,Map<String,Object> content){
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", "9999");
		try {
			String htmlCode = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, Constants.VELOCITY_MODEL_PATH + modelName, "UTF-8", content);
			map.put("code", "0000");
			map.put("html", htmlCode);
		} catch (VelocityException e) {
			e.printStackTrace();
			return map;
		}
		return map;
	}

}
