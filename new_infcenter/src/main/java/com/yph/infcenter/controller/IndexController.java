/**
 * 
 */
package com.yph.infcenter.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.entity.InfcenterInformation;
import com.yph.infcenter.service.InfcenterInformationService;

/**
 * @author bin         
 * 
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
	@Autowired
	private InfcenterInformationService infcenterInformationService;
	

	@RequestMapping(value = "/newsDynamic")
	@ResponseBody
	public String newsDynamic(InfcenterInformation infcenterInformation) {
		String rtn = "";
		List<InfcenterInformation> list = infcenterInformationService.findNewsByOnline(infcenterInformation);
		rtn = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
		return rtn;
	}
	
	@RequestMapping(value="/newsDynamicAll")
	@ResponseBody 
	public String newsDynamicAll(InfcenterInformation infcenterInformation,Integer pageNo,Integer pageSize){
		Map<String, Object> map = new HashMap<String, Object>();
		PageModel list = infcenterInformationService.findNewsByOnlineByPage(infcenterInformation,pageNo, pageSize);
		map.put("result", list);
		map.put("title", "");
		return JSONObject.toJSONString(list);
	}
	
	@RequestMapping(value="/newsDetail")
	@ResponseBody 
	public String newsDetail(InfcenterInformation infcenterInformation){
		InfcenterInformation result = infcenterInformationService.findNewsDetailInfomationById(infcenterInformation);
		if(result!=null&&result.getOperateTime()!=null){
			String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(result.getOperateTime());
			result.setCreateTime(date);
		}
		return JSONObject.toJSONString(result);
	}
}
