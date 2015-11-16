/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterCarouselMapper.java 
 *
 * Created: [2014-12-16 下午03:59:11] by suxuqiang 
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

import java.util.Map;

import com.yph.infcenter.entity.InfcenterCarousel;

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

public interface InfcenterCarouselMapper extends BaseMapper<InfcenterCarousel> {
	/**
	 * Description: 获取首页轮播图列表
	 * 
	 * @param websiteId	站点编号
	 * @param size		轮播图数量
	 * @return map   imgUrl	图片URL
	 *               url	点击后调整地址
	 */
	public Map<String,String> queryBannerToOnline(Map<String,Integer> map);
}
