/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterDictionaryController.java 
 *
 * Created: [2014-12-16 上午11:10:56] by suxuqiang 
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
import com.yph.infcenter.entity.InfcenterDictionary;
import com.yph.infcenter.service.InfcenterDictionaryService;
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
@RequestMapping("/dictionary")
public class InfcenterDictionaryController extends BaseController {
		
	@Autowired
	private InfcenterDictionaryService dictionaryService;
	/**
	 * 
	 * Description:跳转到内容发布平台字典列表 
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 上午11:15:33
	 */
	@RequestMapping(value = "/toDictionaryList")
	public String toDictionaryList(String refreshTag,String messageCode,Model model){
		showMessageAlert(refreshTag,messageCode,model);
		return "app/infcenter/dictionary/dictionary_list";
	}
	/**
	 * 
	 * Description:  列表展示
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午12:06:46
	 */
	@ResponseBody
	@RequestMapping(value="/queryDictionaryList")
	public DataMsg pageList(HttpServletRequest request,DataMsg dataMsg) {
		Map<String, Object> paramsCondition = new HashMap<String, Object>();
		paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
		paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
		String cnNote = request.getParameter("cnNote");//中文注释
		if(StringUtil.isNotBlank(cnNote)){
			paramsCondition.put("cnNote", cnNote.trim());
		}		
		PageModel pageModel = dictionaryService.queryAllByPage(paramsCondition);
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
	 * Create Date: 2014-12-16 下午01:52:26
	 */
	@RequestMapping(value = "/toInsertDictionary")
	public String toInsert(HttpSession session){
		return "app/infcenter/dictionary/dictionary_add"; 
	}
	/**
	 * 
	 * Description: 添加字典
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午01:59:55
	 */
	@ResponseBody
	@RequestMapping(value="/doInsertDictionary")
	public DataMsg doAdd(@ModelAttribute InfcenterDictionary dictionary,DataMsg dataMsg){
		try {						
			dictionaryService.insertDictionary(dictionary);
			
			dataMsg.setMessageCode("0001");
		} catch (Exception e) {
			e.printStackTrace();
			dataMsg.setMessageCode("0002");
		}
		return dataMsg;
	}
	/**
	 * 
	 * Description: 跳转到常量维护修改列表
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午02:24:56
	 */
	@RequestMapping(value="toUpdateDictionary/{id}")
	public String toUpdateDictionary(@PathVariable Integer id,Model model){
		Map<String, Object> dictionaryMap = dictionaryService.findMapById(id);
		model.addAttribute("dictionaryMap", dictionaryMap);
		return "app/infcenter/dictionary/dictionary_edit";		
	}
	/**
	 * 
	 * Description: 修改字典
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午02:27:17
	 */
	@ResponseBody
	@RequestMapping(value="/doUpdateDictionary")
	public DataMsg doEdit(@ModelAttribute InfcenterDictionary dictionary,DataMsg dataMsg){
		try {
			dictionaryService.updateDictionary(dictionary);
			dataMsg.setMessageCode("0003");			
		} catch (Exception e) {
			e.printStackTrace();
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}

}
