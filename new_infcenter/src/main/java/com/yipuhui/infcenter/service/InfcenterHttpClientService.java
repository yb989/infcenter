/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterHttpClientService 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-12-9
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yipuhui.infcenter.service;

import java.io.File;

import com.alibaba.fastjson.JSONObject;

/** 
 *
 * Description: 信息平台客户端接口
 *
 * @author DYP
 * @version 1.0
 * <pre>
 * Modification History: 
 *          Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-9 下午06:24:48 DYP         1.0        1.0 Version 
 * </pre>
 */
public interface InfcenterHttpClientService {
	/**
	  * 
	  * @Description: 获取站点公告
	  *
	  * @param websiteId 站点编号
	  * @param nowDate   当前时间，时间格式为yyyy-YY-dd hh:mm:ss
	  * @return String   
	  * 				 code:返回状态码 （0000：有系统公告；0001：暂时没有系统公告，9999：连接信息发布平台失败）
	  *  				 data:公告信息，code为0000时，有有效数据，格式如下：
	  * 				 {"code":"0000","data":"[{\"noticeInfo\":\"测试一\"},{\"noticeInfo\":\"测试五\"}]"}
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-9 下午06:25:47
	 */
	public JSONObject getWebsiteNotice(String websiteId,String nowDate);
	
	/**
	  * 
	  * @Description: 根据文章主键ID重新生成页面
	  *
	  * @param id
	  * @return
	  * @return String
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-15 下午06:36:54
	 */
	public JSONObject doAgainPublishPage(String id);
	
	/**
	  * 
	  * @Description: 调用文件服务上传图片或文件
	  *
	  * @param	File file  文件
	  * @return JSON
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-25 上午11:15:35
	 */
	public JSONObject doPostFileUpload(File file);
}
