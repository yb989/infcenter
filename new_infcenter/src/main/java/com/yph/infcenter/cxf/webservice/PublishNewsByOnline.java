package com.yph.infcenter.cxf.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.entity.InfcenterInformation;
import com.yph.infcenter.entity.InfcenterPilot;

@WebService
public interface PublishNewsByOnline {
	/**
	 * 返回带有缩略图的前6条公司新闻
	 * 
	 * @param infcenterInformation
	 * @return
	 */
	public List<InfcenterInformation> findNewsByOnline(
			InfcenterInformation infcenterInformation);

	/**
	 * 根据二级菜单返回相对应的新闻列表
	 * 
	 * @param infcenterInformation
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel findNewsByOnlineByPage(
			InfcenterInformation infcenterInformation, Integer pageNo,
			Integer pageSize);

	/**
	 * 返回菜单列表
	 * 
	 * @return
	 */
	public List<InfcenterPilot> findMenuByNews();

	/**
	 * 根据新闻ID返回新闻详细信息
	 * 
	 * @param infcenterInformation
	 * @return
	 */
	public InfcenterInformation findNewsDetailInfomationById(
			InfcenterInformation infcenterInformation);

	/* 150727 新增公司公告webservice新接口 begin */
	/**
	 * 
	 * Description:首页公告
	 * 
	 * @param  websiteId站点主键 
	 * @return String	首页公告，JSON字符串
	 * @throws
	 * @Author yanping Create Date: 2015-7-27 下午04:08:48
	 */
	public String findNoticeOfHomeForOnline(@WebParam(name = "websiteId") Integer websiteId);
	/**
	 * 
	 * Description:更多列表页、公告列表
	 * 
	 * @param  websiteId站点主键
	 * @param  pageNo 	起始页码
	 * @param  pageSize 单页展示条数
	 * 
	 * @return String   公告列表，JSON List<Map<String,String>>
	 * @throws
	 * @Author yanping Create Date: 2015-7-27 下午04:08:25
	 */
	public String findNoticeForOnlineByPage(@WebParam(name = "websiteId") Integer websiteId,@WebParam(name = "pageNo")Integer pageNo,@WebParam(name = "pageSize")Integer pageSize);
	
	/**
	 * 
	 * Description:公告详情页
	 * 
	 * @param  id	  	ID
	 * @return String 	公告详情，JSON字符串
	 * @throws
	 * @Author yanping Create Date: 2015-7-27 下午04:08:35
	 */
	public String findNoticeDetailById(@WebParam(name = "id") Integer id);
	/* 150727 新增公司公告webservice新接口 end */
	
	/* 151030 新增首页banner信息webservice新接口 begin */
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
	/* 151030 新增首页banner信息webservice新接口 end */
}
