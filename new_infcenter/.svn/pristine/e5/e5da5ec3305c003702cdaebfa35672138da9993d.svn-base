/* 
 * Copyright (C) 2006-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: PublishInterfaceOfOnline.java 
 *
 * Created: [2015-7-30 下午05:26:22] by yanping 
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

package com.yph.infcenter.cxf.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 * Description:对外webservice接口
 * 
 * @author yanping
 * @version 1.0
 * 
 *          <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015-7-30    yanping       1.0        1.0 Version
 * </pre>
 */
@WebService
public interface PublishInterfaceOfOnline {
	/**
	 * 
	 * Description: 
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author yanping
	 * Create Date: 2015-7-30 下午06:08:38
	 */
	public String findNewsOfHomeForOnline(
			@WebParam(name = "websiteId") Integer websiteId);
	/**
	 * 
	 * Description: 
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author yanping
	 * Create Date: 2015-7-30 下午06:08:42
	 */
	public String findNewsForOnlineByPage(
			@WebParam(name = "websiteId") Integer websiteId,
			@WebParam(name = "pageNo") Integer pageNo,
			@WebParam(name = "pageSize") Integer pageSize);
	/**
	 * 
	 * Description: 
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author yanping
	 * Create Date: 2015-7-30 下午06:08:46
	 */
	public String findNewsDetailById(@WebParam(name = "id") Integer id);
	/**
	 * 
	 * Description: 
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author yanping
	 * Create Date: 2015-7-30 下午06:08:49
	 */
	public String findNoticeOfHomeForOnline(
			@WebParam(name = "websiteId") Integer websiteId);
	/**
	 * 
	 * Description: 
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author yanping
	 * Create Date: 2015-7-30 下午06:08:52
	 */
	public String findNoticeForOnlineByPage(
			@WebParam(name = "websiteId") Integer websiteId,
			@WebParam(name = "pageNo") Integer pageNo,
			@WebParam(name = "pageSize") Integer pageSize);
	/**
	 * 
	 * Description: 
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author yanping
	 * Create Date: 2015-7-30 下午06:08:55
	 */
	public String findNoticeDetailById(@WebParam(name = "id") Integer id);
	/**
	 * Description: 获取首页轮播图列表
	 * 
	 * @param websiteId	站点编号
	 * @param size		轮播图数量
	 * @return	JSON imgUrl	图片URL
	 *               url	点击后调整地址
	 */
	public String findCarouselsForOnline(@WebParam(name = "websiteId") Integer websiteId,
			@WebParam(name = "size") Integer size);
}
