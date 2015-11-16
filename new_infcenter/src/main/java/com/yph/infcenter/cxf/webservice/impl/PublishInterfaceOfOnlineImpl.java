/* 
 * Copyright (C) 2006-2015 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: PublishInterfaceOfOnlineImpl.java 
 *
 * Created: [2015-7-30 下午05:35:17] by yanping 
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

package com.yph.infcenter.cxf.webservice.impl;

import javax.jws.WebService;

import com.yph.infcenter.cxf.webservice.PublishInterfaceOfOnline;

/** 
 *
 * Description: 
 *
 * @author yanping
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2015-7-30    yanping       1.0        1.0 Version 
 * </pre>
 */
@WebService 
public class PublishInterfaceOfOnlineImpl implements PublishInterfaceOfOnline {
	/*
	 * (non-Javadoc)
	 * @see com.yph.infcenter.cxf.webservice.PublishInterfaceOfOnline#findNewsDetailById(java.lang.Integer)
	 */
	@Override
	public String findNewsDetailById(Integer id) {
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yph.infcenter.cxf.webservice.PublishInterfaceOfOnline#findNewsForOnlineByPage(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String findNewsForOnlineByPage(Integer websiteId, Integer pageNo,
			Integer pageSize) {
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yph.infcenter.cxf.webservice.PublishInterfaceOfOnline#findNewsOfHomeForOnline(java.lang.Integer)
	 */
	@Override
	public String findNewsOfHomeForOnline(Integer websiteId) {
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yph.infcenter.cxf.webservice.PublishInterfaceOfOnline#findNoticeDetailById(java.lang.Integer)
	 */
	@Override
	public String findNoticeDetailById(Integer id) {
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yph.infcenter.cxf.webservice.PublishInterfaceOfOnline#findNoticeForOnlineByPage(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String findNoticeForOnlineByPage(Integer websiteId, Integer pageNo,
			Integer pageSize) {
		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see com.yph.infcenter.cxf.webservice.PublishInterfaceOfOnline#findNoticeOfHomeForOnline(java.lang.Integer)
	 */
	@Override
	public String findNoticeOfHomeForOnline(Integer websiteId) {
		return null;
	}
	@Override
	public String findCarouselsForOnline(Integer websiteId, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

}
