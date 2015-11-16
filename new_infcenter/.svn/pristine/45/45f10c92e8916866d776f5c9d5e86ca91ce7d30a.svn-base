/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterCarouselServiceImpl.java 
 *
 * Created: [2014-12-16 下午05:32:14] by suxuqiang 
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
import com.yph.infcenter.entity.InfcenterCarousel;
import com.yph.infcenter.mapper.InfcenterCarouselMapper;
import com.yph.infcenter.service.InfcenterCarouselService;

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
@Service("InfcenterCarouselService")
public class InfcenterCarouselServiceImpl implements InfcenterCarouselService {
	
	@Autowired
	private InfcenterCarouselMapper carouselMapper;

	/* (non-Javadoc)
	 * @see com.yph.infcenter.service.InfcenterCarouselService#findMapById(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> findMapById(Integer id) {
		// TODO Auto-generated method stub
		return carouselMapper.selectRetMapByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.yph.infcenter.service.InfcenterCarouselService#insertCarousel(com.yph.infcenter.entity.InfcenterCarousel)
	 */
	@Override
	public Integer insertCarousel(InfcenterCarousel carousel) {
		// TODO Auto-generated method stub
		return carouselMapper.insertSelective(carousel);
	}

	/* (non-Javadoc)
	 * @see com.yph.infcenter.service.InfcenterCarouselService#queryAllByPage(java.util.Map)
	 */
	@Override
	public PageModel queryAllByPage(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = carouselMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = carouselMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	/* (non-Javadoc)
	 * @see com.yph.infcenter.service.InfcenterCarouselService#updateCarousel(com.yph.infcenter.entity.InfcenterCarousel)
	 */
	@Override
	public Integer updateCarousel(InfcenterCarousel carousel) {
		// TODO Auto-generated method stub
		return carouselMapper.updateByPrimaryKeySelective(carousel);
	}

}
