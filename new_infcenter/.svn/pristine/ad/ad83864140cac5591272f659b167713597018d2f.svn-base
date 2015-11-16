/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: NoticeServiceImpl.java 
 *
 * Created: [2014-12-4 下午01:12:44] by suxuqiang 
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

package com.yph.infcenter.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.entity.InfcenterNotice;
import com.yph.infcenter.mapper.InfcenterNoticeMapper;
import com.yph.infcenter.service.InfcenterNoticeService;

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
@Service("InfcenterNoticeService")
public class InfcenterNoticeServiceImpl implements InfcenterNoticeService {
	
	@Autowired
	private InfcenterNoticeMapper noticeMapper;

	/* (non-Javadoc)
	 * @see com.yipuhui.infcenter.service.NoticeService#findMapById(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> findMapById(Integer id) {
		return noticeMapper.selectRetMapByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.yipuhui.infcenter.service.NoticeService#insertNotice(com.yipuhui.infcenter.entity.Notice)
	 */
	@Override
	public Integer insertNotice(InfcenterNotice notice) {
		return noticeMapper.insertSelective(notice);
	}

	/* (non-Javadoc)
	 * @see com.yipuhui.infcenter.service.NoticeService#queryAllByPage(java.util.Map)
	 */
	@Override
	public PageModel queryAllByPage(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = noticeMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = noticeMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	/* (non-Javadoc)
	 * @see com.yipuhui.infcenter.service.NoticeService#updateNotice(com.yipuhui.infcenter.entity.Notice)
	 */
	@Override
	public Integer updateNotice(InfcenterNotice notice) {
		return noticeMapper.updateByPrimaryKeySelective(notice);
	}

	@Override
	public List<Map<String, Object>> getWebsiteNotice(Map<String, Object> map) {
		return noticeMapper.findAllRetMapNoPage(map);
	}

	@Override
	public void updateNoticeIsTop(Map<String,Object> map) {
		noticeMapper.updateNoticeIsTop(map);
	}

}
