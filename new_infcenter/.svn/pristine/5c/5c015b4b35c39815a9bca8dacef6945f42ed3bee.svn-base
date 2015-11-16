/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: PublishPageService 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-12-16
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yph.infcenter.service;

import java.util.Map;

import com.yph.infcenter.entity.InfcenterInformation;


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
 * 2014-12-16 下午02:06:11 DYP         1.0        1.0 Version 
 * </pre>
 */
public interface PublishPageService {
	/**
	  * 
	  * @Description: 重新生成缺失页面
	  *
	  * @param id     页面编号，如1.html，则传递1
	  * @return Map<String,String>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-16 下午02:06:51
	 */
	public Map<String,Object> againPublishPage(Integer id) throws Exception;
	
	/**
	  * 
	  * @Description: 在线预览，使用velocity生成html页面源码
	  *
	  * @param infcenterInformation
	  * 
	  * @return Map<String,Object>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-16 下午02:08:43
	 */
	public Map<String,Object> showPageToHtml(InfcenterInformation infcenterInformation) throws Exception;
}
