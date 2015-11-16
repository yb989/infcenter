/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterDictionaryServiceImpl.java 
 *
 * Created: [2014-12-16 上午10:53:33] by suxuqiang 
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
import com.yph.infcenter.entity.InfcenterDictionary;
import com.yph.infcenter.mapper.InfcenterDictionaryMapper;
import com.yph.infcenter.service.InfcenterDictionaryService;

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
@Service("InfcenterDictionaryService")
public class InfcenterDictionaryServiceImpl implements
		InfcenterDictionaryService {
	
	@Autowired
	private InfcenterDictionaryMapper dictionaryMapper;

	/* (non-Javadoc)
	 * @see com.yph.infcenter.service.InfcenterDictionaryService#findMapById(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> findMapById(Integer id) {
		// TODO Auto-generated method stub
		return dictionaryMapper.selectRetMapByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.yph.infcenter.service.InfcenterDictionaryService#insertNotice(com.yph.infcenter.entity.InfcenterDictionary)
	 */
	@Override
	public Integer insertDictionary(InfcenterDictionary dictionary) {
		// TODO Auto-generated method stub
		return dictionaryMapper.insertSelective(dictionary);
	}

	/* (non-Javadoc)
	 * @see com.yph.infcenter.service.InfcenterDictionaryService#queryAllByPage(java.util.Map)
	 */
	@Override
	public PageModel queryAllByPage(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = dictionaryMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = dictionaryMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	/* (non-Javadoc)
	 * @see com.yph.infcenter.service.InfcenterDictionaryService#updateNotice(com.yph.infcenter.entity.InfcenterDictionary)
	 */
	@Override
	public Integer updateDictionary(InfcenterDictionary dictionary) {
		// TODO Auto-generated method stub
		return dictionaryMapper.updateByPrimaryKeySelective(dictionary);
	}

}
