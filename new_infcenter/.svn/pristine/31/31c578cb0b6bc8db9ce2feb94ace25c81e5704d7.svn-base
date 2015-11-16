/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterPilotServiceImpl 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-12-8
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yph.infcenter.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yph.infcenter.entity.InfcenterPilot;
import com.yph.infcenter.mapper.InfcenterPilotMapper;
import com.yph.infcenter.service.InfcenterPilotService;

/**
 * 
 * Description: TODO
 * 
 * @author DYP
 * @version 1.0
 * 
 *          <pre>
 * Modification History: 
 *          Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-8 下午03:27:11 DYP         1.0        1.0 Version
 * </pre>
 */
@Service("infcenterPilotService")
public class InfcenterPilotServiceImpl implements InfcenterPilotService {
	@Autowired
	private InfcenterPilotMapper infcenterPilotMapper;
	
	@Override
	public List<Map<String, Object>> queryDirectionPilot(Map<String, Object> map) {
		return infcenterPilotMapper.queryDirectionPilot(map);
	}

	@Override
	public List<Map<String, Object>> queryFirstPilot(Map<String, Object> map) {
		return infcenterPilotMapper.queryFirstPilot(map);
	}

	@Override
	public void insertPilot(Map<String, Object> map) {
		infcenterPilotMapper.insertPilot(map);
	}

	@Override
	public Integer getMaxFirstPilot(Integer parentId) {
		return infcenterPilotMapper.getMaxFirstPilot(parentId);
	}

	@Override
	public List<Map<String, Object>> findFirstPilotInfo() {
		return infcenterPilotMapper.findFirstPilotInfo();
	}

	@Override
	public List<Map<String, Object>> findSubWorkPilotInfoById(Integer id) {
		return infcenterPilotMapper.findSubWorkPilotInfoById(id);
	}

	@Override
	public Map<String, Object> findVelocityNameById(Integer id) {
		return infcenterPilotMapper.findVelocityById(id);
	}

	@Override
	public Integer findIdByIdColumnZhName(String name) {
		return infcenterPilotMapper.findIdByIdColumnZhName(name);
	}
	
	@Override
	public List<Map<String, Object>> queryPilots() {
		return infcenterPilotMapper.queryPilots();
	}

	@Override
	public InfcenterPilot queryByIdPilot(Integer id) {
		return infcenterPilotMapper.queryByIdPilot(id);
	}

	@Override
	public Integer updateByPrimaryKeySelective(InfcenterPilot infcenterPilot) {
		return infcenterPilotMapper.updateByPrimaryKeySelective(infcenterPilot);
	}

	@Override
	public Integer insertSelectivePolit(InfcenterPilot infcenterPilot) {
		return infcenterPilotMapper.insertSelectivePolit(infcenterPilot);
	}

	@Override
	public Integer deleteInfcenterPilot(Integer id) {
		return infcenterPilotMapper.deleteInfcenterPilot(id);
	}

	@Override
	public Integer findIdByZhName(String zhName) {
		return infcenterPilotMapper.findIdByZhName(zhName);
	}

	@Override
	public Map<String, Object> findPilotById(Integer id) {
		return infcenterPilotMapper.findPilotById(id);
	}

	@Override
	public List<InfcenterPilot> queryFirstMenu(Map<String, Object> map) {
		return infcenterPilotMapper.queryFirstMenu(map);
	}

	@Override
	public Map<String, Object> queryMenuSort(Map<String,Object> map) {
		return infcenterPilotMapper.queryMenuSort(map);
	}

	/**
	 * 根据当前顺序和父ID获取下一条数据
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> queryMenuSortByDown(Map<String, Object> map) {
		return infcenterPilotMapper.queryMenuSortByDown(map);
	}

}
