/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: NoticeController.java 
 *
 * Created: [2014-12-4 下午01:28:35] by suxuqiang 
 *
 * $Id$
 * 
 * $Revision$
 *
 * $Author$
 *
 * $Date$
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yph.infcenter.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yph.infcenter.common.util.DataMsg;
import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.entity.InfcenterNotice;
import com.yph.infcenter.service.InfcenterNoticeService;
import com.yph.toolcenter.util.StringUtil;

/** 
 *
 * Description: 
 *
 * @author ua
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-4    suxuqiang       1.0        1.0 Version 
 * </pre>
 */
@Controller
@RequestMapping("/notice")
public class InfcenterNoticeController extends BaseController {
	
	
	@Autowired
	private InfcenterNoticeService noticeService;
	/**
	 * 
	 * Description: 跳转到公告发布列表
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 下午01:35:54
	 */
	@RequestMapping(value = "/toNoticeList")
	public String toNoticeList(String refreshTag,String messageCode,Model model){
		showMessageAlert(refreshTag,messageCode,model);
		return "app/infcenter/notice/notice_list";
	}
	/**
	 * 
	 * Description: 显示公告发布信息列表
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 下午01:41:33
	 */
	@ResponseBody
	@RequestMapping(value="/queryNoticeList")
	public DataMsg pageList(HttpServletRequest request,DataMsg dataMsg) {
		Map<String, Object> paramsCondition = new HashMap<String, Object>();
		paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
		paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
		String websiteId = request.getParameter("websiteId");//站点ID
		if(StringUtil.isNotBlank(websiteId)){
			paramsCondition.put("websiteId", websiteId.trim());
		}
		String isEffective = request.getParameter("isEffective");//是否为即时公告
		if(StringUtil.isNotBlank(isEffective)){
			paramsCondition.put("isEffective", isEffective.trim());
		}
		String title = StringUtil.trim(request.getParameter("title"));
		if(StringUtil.isNotBlank(title)){
			paramsCondition.put("title", title);
		}
		String isTop = StringUtil.trim(request.getParameter("isTop"));
		if(StringUtil.isNotBlank(isTop)){
			paramsCondition.put("isTop", isTop);
		}
		String beginTimeBegin = request.getParameter("beginTimeBegin");//公告生效开始时间		
		if(StringUtil.isNotBlank(beginTimeBegin)){
			paramsCondition.put("beginTimeBegin", beginTimeBegin.trim());
		}
		String beginTimeEnd = request.getParameter("beginTimeEnd");//公告生效结束时间		
		if(StringUtil.isNotBlank(beginTimeEnd)){
			paramsCondition.put("beginTimeEnd", beginTimeEnd.trim());
		}
		String endTimeBegin = request.getParameter("endTimeBegin");//公告失效开始时间
		if(StringUtil.isNotBlank(endTimeBegin)){
			paramsCondition.put("endTimeBegin", endTimeBegin.trim());
		}
		String endTimeEnd = request.getParameter("endTimeEnd");//公告失效结束时间
		if(StringUtil.isNotBlank(endTimeEnd)){
			paramsCondition.put("endTimeEnd", endTimeEnd.trim());
		}
		PageModel pageModel = noticeService.queryAllByPage(paramsCondition);
		dataMsg.setTotal(pageModel.getTotalRecords());
		dataMsg.setRows(pageModel.getList());
		return dataMsg;
	}
	
	/**
	 * 跳转到添加公告页面
	 * Description: 
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 下午02:44:17
	 */
	@RequestMapping(value = "/toInsertNotice")
	public String toInsert(HttpSession session){
		return "app/infcenter/notice/notice_add"; 
	}
	/**
	 * 
	 * Description: 添加公告
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 下午02:44:42
	 */
	@ResponseBody
	@RequestMapping(value="/doInsertNotice")
	public DataMsg doAdd(@ModelAttribute InfcenterNotice notice,DataMsg dataMsg,HttpSession session){
		Map<String,Object> map = null;
		try {
			if(notice.getIsTop().equals("1")){
				map = new HashMap<String,Object>();
				map.put("isTop","0");
				noticeService.updateNoticeIsTop(map);
			}
			notice.setOperator(getSystemCurrentUser(session).getEmployeeId());
			notice.setCreateTime(new Date());
			notice.setOperateTime(new Date());
			noticeService.insertNotice(notice);
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			e.printStackTrace();
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}
	/**
	 * 
	 * Description: 跳转到更新公告页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 下午05:15:05
	 */
	@RequestMapping(value="toUpdateNotice/{id}")
	public String toUpdate(@PathVariable Integer id,Model model){
		Map<String, Object> noticeMap = noticeService.findMapById(id);
		model.addAttribute("noticeMap", noticeMap);
		return "app/infcenter/notice/notice_edit";		
	}
	/**
	 * 
	 * Description: 更新公告
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 下午05:17:32
	 */
	@ResponseBody
	@RequestMapping(value="/doUpdateNotice")
	public DataMsg doEdit(@ModelAttribute InfcenterNotice notice,DataMsg dataMsg,HttpSession session){
		Map<String,Object> map = null;
		try {
			if(notice.getIsTop().equals("1")){
				map = new HashMap<String,Object>();
				map.put("isTop","0");
				noticeService.updateNoticeIsTop(map);
			}
			notice.setOperator(getSystemCurrentUser(session).getEmployeeId());
			notice.setOperateTime(new Date());	
			dataMsg.setMessageCode("0003");
			noticeService.updateNotice(notice);
		} catch (Exception e) {
			e.printStackTrace();
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}
	
	/**
	  * 
	  * @Description: 获取站点公告
	  *
	  * @param  map
	  * 		websiteId 站点编号
	  * 		nowDate   当前时间，时间格式为yyyy-YY-dd hh:mm:ss
	  * @return json字符串
	  * @return String
	  * @throws Exception 
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-9 下午05:17:59
	 */
	@RequestMapping(value="/getWebsiteNotice",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
	public @ResponseBody List<Map<String,Object>> getWebsiteNotice(@RequestParam Integer websiteId,@RequestParam String nowDate){
		if(websiteId == null){
			return null;
		}
		if(StringUtil.isBlank(nowDate)){
			return null;
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("websiteId", websiteId);
		map.put("nowDate", nowDate);
		List<Map<String,Object>> noticeList = noticeService.getWebsiteNotice(map);
		return noticeList;
	}
}
