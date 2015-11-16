/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: NoticeService.java 
 *
 * Created: [2014-12-4 上午11:55:58] by suxuqiang 
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

package com.yph.infcenter.service;

import java.util.List;
import java.util.Map;

import com.yph.infcenter.common.util.PageModel;
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

public interface InfcenterNoticeService {
	/**
	 * 
	 * Description: 分页查询公告信息
	 *
	 * @param 
	 * @return PageModel
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 上午11:56:34
	 */
	public PageModel queryAllByPage(Map<String, Object> paramsCondition);
	/**
	 * 
	 * Description: 添加公告
	 *
	 * @param 
	 * @return Integer
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 上午11:58:41
	 */
	public Integer insertNotice(InfcenterNotice notice);
	/**
	 * 
	 * Description: 通过ID查询公告
	 *
	 * @param 
	 * @return Map<String,Object>
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 上午11:59:19
	 */
	public Map<String, Object> findMapById(Integer id);
	/**
	 * 
	 * Description: 更新公告
	 *
	 * @param 
	 * @return Integer
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-4 下午12:00:01
	 */
	public Integer updateNotice(InfcenterNotice notice);
	/**
	  * 
	  * @Description: 获取站点公告
	  *
	  * @param @param map
	  * @param @return
	  * @return List<Map<String,Object>>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-9 下午05:52:39
	 */
	public List<Map<String,Object>> getWebsiteNotice(Map<String,Object> map);
	
	/**
	 * 
	 * Description:修改为置顶时，剩下的信息全部设置为否
	 *
	 * @param 
	 * @return void
	 * @throws 
	 * @Author ywb
	 * Create Date: 2015-07-28 上午11:59:19
	 */
	public void updateNoticeIsTop(Map<String,Object> map);
	
}
