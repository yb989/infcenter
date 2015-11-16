/* 
 * Copyright (C) 2011-2013 达飞普惠财富投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: Constants.java 
 *
 * Created: [2014-1-7 下午01:15:47] by yaodawei 
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

package com.yph.infcenter.common.constant;

import com.yph.infcenter.common.util.PropertyUtil;

/** 
 *
 * Description: 系统常量
 *
 * @author yaodawei
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-1-7    yaodawei       1.0        1.0 Version 
 * </pre>
 */
public class Constants {
	
	public static final int PAGE_SIZE = 10;
	
	public static final String MANAGER_ACCOUNT = "admin";              
	
	public static final String SYSTEM_USER = "SystemUser";//后台管理系统登陆用户session的key值
	
	public static final String WORK_DEPT_IDS = "workDeptIds";//当前登录人拥有的数据权限
	
	public static final String SYSTEM_USER_ROLES = "SystemUserRoles";//当前登录人拥有的角色
	
	public static final String UPLOAD_FILE_TYPE = "*.pdf;*.jpg;*.png;*.jpeg;*.gif;*.tif;*.TIF;*.tiff;*.TIFF;*.PDF;*.JPG;*.PNG;*.JPEG;*.GIF;*.rar;*.RAR;*.zip;*.ZIP;*.txt;*.doc;*.docx;*.xls;*.xlsx;";//上传的文件类型
	
	public static final String ATTACHMENT_FILE_TYPE_1 = "customerInfo"; //客户信息附件的上传目录
	
	public static final String ATTACHMENT_FILE_TYPE_2 = "investInfo"; //投资申请附件上传的目录
	
	public static final String ATTACHMENT_FILE_TYPE_3 = "activityInfo";//活动附件上传的目录
	
	public static final String CHECK_CODE ="check_code";//验证码key值
	
	public static final String NOT_FOUND_CODE = "404";//请求不能找到
	
	public static final String CTRL_NAME = "ctrl"; //按钮权限key值
	
	public static final String ACTIVATED_STATE_DISABLE = "0";//员工用户使用状态：0:停用
	
	public static final String ACTIVATED_STATE_ENABLED = "1";//员工用户使用状态：1:启用
	
	public static final String PAY_CASH = "1";//现金支付
	
	public static final String TRA_PRIVATE = "2";//对私转账
	
	public static final String TRA_PUBLIC = "3";//对公
	
	public static final String ACTIVITY_START_NO = "1";//活动状态 未开始
	
	public static final String ACTIVITY_DO_ING = "2";//活动状态  进行中
	
	public static final String ACTIVITY_DO_OVER = "3";//活动状态  已结束
	
	public static final String IS = "1";//是
	
	public static final String NOT = "0";//否
	
	public static final String CUSTOMER_SOURCE_LAO_KE_HU_TUI_JIAN = "3";//客户来源I 老客户推荐
	
	public static final String CUSTOMER_SOURCE_TUI_GUANG_HUO_DONG = "4";//客户来源I 推广活动
	
	public static final String CUSTOMER_SOURCE_ZHONG_ZI_JIA_HUA = "7";//客户来源I 种子计划
	
	public static final String CUSTOMER_INTENTION_YXQL = "1";//意向强烈
	
	public static final String CUSTOMER_INTENTION_YXYB = "2";//意向一般
	
	public static final String CUSTOMER_INTENTION_WYX = "3";//无意向
	
	/***************接口数据同步状态start*****************/
	public static final String SYN_INTERFACE_STATE_TBCG = "1";//同步成功
	
	public static final String SYN_INTERFACE_STATE_TBSB = "2";//同步失败
	/***************接口数据同步状态end*****************/
	
	public static final String SYSTEM_IDENTIFYING_HXXT = "HXXT";//核心系统标识
	
	public static final String SYSTEM_DICT_ID_CARD = "01"; //字典身份证
	
	public static final String CARD_LONG_VALID = "1";//证件长期有效
	
	public static final String CARD_LONG_INVALID = "0";//证件不是长期有效
	
	public static final String VELOCITY_MODEL_PATH = "../../template/";
	
	public static final String DES_KEY = "eph!@#$%infcenter123,./";//des加密算法key
	
	public static final String MODEL_NAME = "eph_website_online.vm";
	
	
	
	public static final String WEB_DOMAIN_URL = PropertyUtil.getInfo("WEB_DOMAIN_URL");
	public static final String WEB_TITLE = PropertyUtil.getInfo("WEB_TITLE");
	public static final String COPYRIGHT = PropertyUtil.getInfo("COPYRIGHT");
	public static final String IT_SUPPORT = PropertyUtil.getInfo("IT_SUPPORT");
	public static final String SPONSOR = PropertyUtil.getInfo("SPONSOR");
	public static final String CONTRACTORS = PropertyUtil.getInfo("CONTRACTORS");
	public static final String EMAIL = PropertyUtil.getInfo("EMAIL");
	public static final String TEL = PropertyUtil.getInfo("TEL");
	public static final String ICP = PropertyUtil.getInfo("ICP");
		
}