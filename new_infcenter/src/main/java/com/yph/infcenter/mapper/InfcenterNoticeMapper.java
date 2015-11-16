/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: NoticeMapper.java 
 *
 * Created: [2014-12-4 上午11:16:07] by suxuqiang 
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

package com.yph.infcenter.mapper;

import java.util.List;
import java.util.Map;

import com.yph.infcenter.entity.InfcenterNotice;

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

public interface InfcenterNoticeMapper extends BaseMapper<InfcenterNotice>{
	
	/**
	 * 设置数据是否置顶为否
	 */
	public void updateNoticeIsTop(Map<String,Object> map);
	
	/* 150727 新增公司公告 begin */
	/**
	 * 
	 * Description:首页公告
	 * 
	 * @param  websiteId站点主键 
	 * @return String	首页公告，JSON字符串
	 * @throws
	 * @Author yanping Create Date: 2015-7-27 下午04:08:48
	 */
	public Map<String,String> findNoticeOfHomeForOnline(Integer websiteId);
	/**
	 * 
	 * Description:更多列表页、公告列表
	 * 
	 * @param  type   	类型（XW：新闻；GG：公告）
	 * @param  pageNo 	起始页码
	 * @param  pageSize 单页展示条数
	 * 
	 * @return String   公告列表，JSON List<Map<String,String>>
	 * @throws
	 * @Author yanping Create Date: 2015-7-27 下午04:08:25
	 */
	public List<Map<String,String>> findNoticeForOnlineByPage(InfcenterNotice notice);
	/**
	 * 
	 * Description: 分页条数
	 *
	 * @param 
	 * @return Long
	 * @throws 
	 * @Author yanping
	 * Create Date: 2015-7-28 下午04:17:32
	 */
	public Long findNoticeForOnlineByPageCount(InfcenterNotice notice);
	/**
	 * 
	 * Description:公告详情页
	 * 
	 * @param  id	  	ID
	 * @return String 	公告详情，JSON字符串
	 * @throws
	 * @Author yanping Create Date: 2015-7-27 下午04:08:35
	 */
	public Map<String,String> findNoticeDetailById(Integer id);
	/* 150727 新增公司公告 end */
}
