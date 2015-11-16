/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterVelocityService 
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
package com.yph.infcenter.service;

import java.util.Map;



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
 * 2014-12-15 下午03:00:18 DYP         1.0        1.0 Version 
 * </pre>
 */
public interface InfcenterVelocityService {
	/**
	  * 
	  * @Description: 使用velocity进行页面的发布
	  *
	  * @param savePath  文件保存路径
	  * @param fileName  文件保存名称
	  * @param modelName 模板名称
	  * @param content   组装数据
	  * 
	  * @return Map<String,String>
	  *   				 0000 成功
	  *   				 9999 失败
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-15 下午03:08:46
	 */
	public Map<String,Object> createVelocityForHtml(String savePath,String fileName,String modelName,Map<String,Object> content);
	
	/**
	  * 
	  * @Description: 使用velocity在线生成页面源码
	  *
	  * @param modelName 模板名称
	  * @param content   组装数据
	  * 
	  * @return Map<String,String>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-15 下午03:34:08
	 */
	public Map<String,Object> showVelocityForHtml(String modelName,Map<String,Object> content);
	
}
