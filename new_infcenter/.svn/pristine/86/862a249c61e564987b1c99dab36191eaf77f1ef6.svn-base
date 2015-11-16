/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterCarouselController.java 
 *
 * Created: [2014-12-16 下午05:37:01] by suxuqiang 
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

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yph.infcenter.common.util.DataMsg;
import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.entity.InfcenterCarousel;
import com.yph.infcenter.service.InfcenterCarouselService;
import com.yph.toolcenter.util.DateTimeUtil;
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
 * 2014-12-16    suxuqiang       1.0        1.0 Version 
 * </pre>
 */
@Controller
@RequestMapping("/carousel")
public class InfcenterCarouselController extends BaseController {
	
	@Autowired
	private InfcenterCarouselService carouselService;
	/**
	 * 
	 * Description: 跳转到轮播图列表页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午05:39:04
	 */
	@RequestMapping(value = "/toCarouselList")
	public String toCarouselList(String refreshTag,String messageCode,Model model){
		showMessageAlert(refreshTag,messageCode,model);
		return "app/infcenter/carousel/carousel_list";
	}
	/**
	 * 
	 * Description: 分页展示首页轮播图
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午05:48:06
	 */
	@ResponseBody
	@RequestMapping(value="/queryCarouselList")
	public DataMsg pageList(HttpServletRequest request,DataMsg dataMsg) {
		Map<String, Object> paramsCondition = new HashMap<String, Object>();
		paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
		paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
		String websiteId = request.getParameter("websiteId");//站点ID
		if(StringUtil.isNotBlank(websiteId)){
			paramsCondition.put("websiteId", websiteId.trim());
		}
		String isEffective = request.getParameter("isEffective");//是否有效
		if(StringUtil.isNotBlank(isEffective)){
			paramsCondition.put("isEffective", isEffective.trim());
		}
		String beginTimeBegin = request.getParameter("beginTimeBegin");//开始时间		
		if(StringUtil.isNotBlank(beginTimeBegin)){
			paramsCondition.put("beginTimeBegin", beginTimeBegin.trim());
		}
		String beginTimeEnd = request.getParameter("beginTimeEnd");//结束时间		
		if(StringUtil.isNotBlank(beginTimeEnd)){
			paramsCondition.put("beginTimeEnd", beginTimeEnd.trim());
		}
		String endTimeBegin = request.getParameter("endTimeBegin");//开始时间
		if(StringUtil.isNotBlank(endTimeBegin)){
			paramsCondition.put("endTimeBegin", endTimeBegin.trim());
		}
		String endTimeEnd = request.getParameter("endTimeEnd");//结束时间
		if(StringUtil.isNotBlank(endTimeEnd)){
			paramsCondition.put("endTimeEnd", endTimeEnd.trim());
		}
		PageModel pageModel = carouselService.queryAllByPage(paramsCondition);
		dataMsg.setTotal(pageModel.getTotalRecords());
		dataMsg.setRows(pageModel.getList());
		return dataMsg;
	}
	/**
	 * 
	 * Description: 跳转到添加页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-17 上午10:11:51
	 */
	@RequestMapping(value = "/toInsertCarousel")
	public String toInsert(HttpSession session){
		return "app/infcenter/carousel/carousel_add"; 
	}
	/**
	 * 
	 * Description: 添加轮播图
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-17 上午10:15:53
	 */
	@ResponseBody
	@RequestMapping(value="/doInsertCarousel")
	public DataMsg doAdd(@ModelAttribute InfcenterCarousel carousel,DataMsg dataMsg){
		try {
			carousel.setOperateTime(new Date());
			carousel.setOperator(1);
			if(carousel.getEndTime() == null)
				carousel.setEndTime(DateTimeUtil.changeDate(new Date(),Calendar.DATE, 100000));
			carouselService.insertCarousel(carousel);
			
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			e.printStackTrace();
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}
	/**
	 * 
	 * Description: 跳转到修改轮播图页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-17 上午10:34:39
	 */
	@RequestMapping(value="toUpdateCarousel/{id}")
	public String toUpdate(@PathVariable Integer id,Model model){
		Map<String, Object> carouselMap = carouselService.findMapById(id);
		model.addAttribute("carouselMap", carouselMap);
		return "app/infcenter/carousel/carousel_edit";		
	}
	/**
	 * 
	 * Description: 修改轮播图
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-17 上午10:36:51
	 */
	@ResponseBody
	@RequestMapping(value="/doUpdateCarousel")
	public DataMsg doEdit(@ModelAttribute InfcenterCarousel carousel,DataMsg dataMsg){
		try {			
			carousel.setOperateTime(new Date());			
			dataMsg.setMessageCode("0003");
			carouselService.updateCarousel(carousel);
		} catch (Exception e) {
			e.printStackTrace();
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}

}
