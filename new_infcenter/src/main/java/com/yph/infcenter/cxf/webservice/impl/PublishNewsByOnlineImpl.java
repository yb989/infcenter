package com.yph.infcenter.cxf.webservice.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.cxf.webservice.PublishNewsByOnline;
import com.yph.infcenter.entity.InfcenterInformation;
import com.yph.infcenter.entity.InfcenterNotice;
import com.yph.infcenter.entity.InfcenterPilot;
import com.yph.infcenter.mapper.InfcenterCarouselMapper;
import com.yph.infcenter.mapper.InfcenterInformationMapper;
import com.yph.infcenter.mapper.InfcenterNoticeMapper;
import com.yph.infcenter.service.InfcenterPilotService;

@WebService
public class PublishNewsByOnlineImpl implements PublishNewsByOnline {

	@Autowired
	private InfcenterInformationMapper infcenterInformationMapper;
	@Autowired
	private InfcenterPilotService infcenterPilotService;
	@Autowired
	private InfcenterNoticeMapper infcenterNoticeMapper;
	@Autowired
	private InfcenterCarouselMapper infcenterCarouselMapper;
	
	
	@Override
	public List<InfcenterInformation> findNewsByOnline(InfcenterInformation infcenterInformation) {
		return infcenterInformationMapper.findNewsInfomationById(infcenterInformation);
	}
	@Override
	public PageModel findNewsByOnlineByPage(
			InfcenterInformation infcenterInformation,Integer pageNo,Integer pageSize) {
		PageModel pageModel = new PageModel();
		Map<String, Object> paramsCondition = new HashMap<String,Object>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		paramsCondition.put("pageNo", pageNo);
		paramsCondition.put("pageSize", pageSize);
		paramsCondition.put("secondLevelId", infcenterInformation.getSecondLevelId());
		List<InfcenterInformation> data = infcenterInformationMapper.findNewsInfomationByPage(paramsCondition);
		for (InfcenterInformation infcenterInformation2 : data) {
			if(infcenterInformation2.getOperateTime()!=null){
				String date = new SimpleDateFormat("yyyy-MM-dd").format(infcenterInformation2.getOperateTime());
				infcenterInformation2.setCreateTime(date);
			}
		}
		Long totalRecords = infcenterInformationMapper.findNewsInfomationByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public List<InfcenterPilot> findMenuByNews() {
		Map<String,Object> map = new HashMap<String, Object>();
		List<InfcenterPilot> firstPilot = infcenterPilotService.queryFirstMenu(map);
		return firstPilot;
	}
	@Override
	public InfcenterInformation findNewsDetailInfomationById(InfcenterInformation infcenterInformation) {
		return infcenterInformationMapper.findNewsDetailInfomationById(infcenterInformation);
	}
	/*
	 * (non-Javadoc)
	 * @see com.yph.infcenter.cxf.webservice.PublishNewsByOnline#findNoticeDetailById(java.lang.Integer)
	 */
	@Override
	public String findNoticeDetailById(Integer id) {
		Map<String,String> rmap = getMap();
		try {
			Map<String,String> map = infcenterNoticeMapper.findNoticeDetailById(id);
			rmap = getRMap(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(rmap);
	}
	/*
	 * (non-Javadoc)
	 * @see com.yph.infcenter.cxf.webservice.PublishNewsByOnline#findNoticeForOnlineByPage(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String findNoticeForOnlineByPage(Integer websiteId,Integer pageNo,Integer pageSize) {
		Map<String,String> rmap = getMap();
		try {
			InfcenterNotice notice = new InfcenterNotice();
			notice.setWebsiteId(websiteId);
			//实际传递为页码，1，2，3之类，转为limit数据，实际传递应为0，10，20之类
			Integer pa = (pageNo - 1) * pageSize;
			notice.setPageNo(pa);
			notice.setPageSize(pageSize);
			List<Map<String,String>> list = infcenterNoticeMapper.findNoticeForOnlineByPage(notice);
			Long count = infcenterNoticeMapper.findNoticeForOnlineByPageCount(notice);
			rmap = new HashMap<String, String>();
			rmap.put("size", String.valueOf(count));
			rmap.put("list", JSON.toJSONString(list));
			rmap = getRMap(rmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(rmap);
	}
	/*
	 * (non-Javadoc)
	 * @see com.yph.infcenter.cxf.webservice.PublishNewsByOnline#findNoticeOfHomeForOnline()
	 */
	@Override
	public String findNoticeOfHomeForOnline(Integer websiteId) {
		Map<String,String> rmap = getMap();
		try {
			Map<String,String> map = infcenterNoticeMapper.findNoticeOfHomeForOnline(websiteId);
			rmap = getRMap(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(rmap);
	}
	
	/**
	 * 
	 * Description: 初始化数据
	 *
	 * @param 
	 * @return Map<String,String>
	 * @throws 
	 * @Author yanping
	 * Create Date: 2015-7-28 下午04:38:33
	 */
	private static Map<String,String> getMap(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("code", "500");
		map.put("msg" , "服务器异常");
		return map;
	}
	
	/**
	 * 
	 * Description: 查询成功，更新初始化数据
	 *
	 * @param 
	 * @return Map<String,String>
	 * @throws 
	 * @Author yanping
	 * Create Date: 2015-7-28 下午04:38:36
	 */
	private static Map<String,String> getRMap(Map<String,String> map){
		if(map == null || map.isEmpty()){
			map = new HashMap<String, String>();
			map.put("code", "500");
			map.put("msg" , "暂无数据");
		}else{
			map.put("code", "200");
			map.put("msg" , "查询成功");
		}
		return map;
	}
	
	@Override
	public String findCarouselsForOnline(Integer websiteId, Integer size) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("websiteId", websiteId);
		map.put("size", size);
		Map<String,String> rmap = infcenterCarouselMapper.queryBannerToOnline(map);
		rmap = getRMap(rmap);
		return JSON.toJSONString(rmap);
	}
}
