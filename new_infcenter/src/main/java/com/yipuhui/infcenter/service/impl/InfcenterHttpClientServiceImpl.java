/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterHttpClientService 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-12-9
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yipuhui.infcenter.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yipuhui.infcenter.service.InfcenterHttpClientService;
import com.yph.infcenter.common.util.PropertyUtil;
import com.yph.infcenter.common.util.StringUtil;

/** 
 *
 * Description: TODO
 *
 * @author DYP
 * @version 1.0
 * <pre>
 * Modification History: 
 *          Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-9 下午06:26:55 DYP         1.0        1.0 Version 
 * </pre>
 */
public class InfcenterHttpClientServiceImpl implements InfcenterHttpClientService {
	
	/*静态内部类 优点：加载时不会初始化静态变量INSTANCE，因为没有主动使用，达到Lazy loading*/
	private static class SingletonHolder {
		private final static InfcenterHttpClientServiceImpl INSTANCE = new InfcenterHttpClientServiceImpl();
	}

	private InfcenterHttpClientServiceImpl() {
	}

	public static InfcenterHttpClientServiceImpl getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	/* (非 Javadoc)
	
	 * <p>Title: getWebsiteNotice</p>
	 * <p>Description: TODO</p>
	 * @param websiteId
	 * @param nowDate
	 * @return
	 * @see com.yipuhui.infcenter.service.InfcenterHttpClientService#getWebsiteNotice(java.lang.Integer, java.lang.String)
	 */
	@Override
	public JSONObject getWebsiteNotice(String websiteId, String nowDate) {
		// 设置post调用的URL
		String url = PropertyUtil.getInfo("WEB_URL") + "/notice/getWebsiteNotice";
		// 添加请求参数
		NameValuePair[] pair = new NameValuePair[] {
				new NameValuePair("websiteId"  ,websiteId),
				new NameValuePair("nowDate"	   ,nowDate),
		};
		return toHttpClientServer(url,pair,null,"1");
	}
	
	/*
	 * (非 Javadoc)
	
	 * <p>Title: doAgainPublishPage</p>
	 * <p>Description: TODO</p>
	 * @param id
	 * @return
	 * @see com.yipuhui.infcenter.service.InfcenterHttpClientService#doAgainPublishPage(java.lang.Integer)
	 */
	@Override
	public JSONObject doAgainPublishPage(String id){
		// 设置post调用的URL
		String url = PropertyUtil.getInfo("WEB_URL") + "/publishPage/againPublishPage/" + id;
		
		// 添加请求参数
		NameValuePair[] pair = new NameValuePair[] {
				new NameValuePair("id"  ,id),
		};
		return toHttpClientServer(url,pair,null,"1");
	}
	
	
	@Override
	public JSONObject doPostFileUpload(File file){
		// 设置post调用的URL
		String url = PropertyUtil.getInfo("IMAGESERVICE_UPLOAD_URL");
		
		Part[] part = null;
		// 添加请求参数
		try {
			part = new Part[] { new FilePart("file", file) };
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Object> map = new HashMap<String,Object>();
			//初始化数据：9999-连接信息发布平台失败
			map.put("code", "9999");
			map.put("data", "");
			return JSONObject.parseObject(JSON.toJSONString(map, true));
		}
		return toHttpClientServer(url,null,part,"2");
	}
	
	/**
	 * 
	  * 
	  * @Description: 使用httpclient进行数据通信
	  *
	  * @param serverUrl	请求地址
	  * @param pair			请求数据
	  * 
	  * @return String
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-15 下午06:33:30
	 */
	private JSONObject toHttpClientServer(String serverUrl,NameValuePair[] pair,Part[] parts,String type){
		
		// 使用了一个多线程连接管理器的类
		MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
		// 定义client对象
		org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient(connectionManager);
		// 指定传送字符集格式
		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		// 设置连接超时时间为30秒（连接初始化时间）
		client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
		// 设置post调用的URL
		PostMethod method = new PostMethod(serverUrl);
		
		Map<String,Object> map = new HashMap<String,Object>();
		//初始化数据：9999-连接信息发布平台失败
		map.put("code", "9999");
		map.put("data", "");
		
		try {
			if("1".equals(type)){
				// 进行通信
				method.setRequestBody(pair);
			}else if("2".equals(type)){
				//5 设置实体
				MultipartRequestEntity entity = new MultipartRequestEntity(parts, method.getParams());
				method.setRequestEntity(entity);
			}
	
			for (int i = 0; i < 3; i++) {
				Integer thirdCode = client.executeMethod(method);
				if (thirdCode == HttpStatus.SC_OK) {
					InputStream inputStream = method.getResponseBodyAsStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
					String str = "";
					StringBuffer sb = new StringBuffer();
					while ((str = br.readLine()) != null) {
						sb.append(str);
					}
					if(StringUtil.blank(new String(sb))){
						map.put("code", "0001");
					}else{
						map.put("code", "0000");
						String reMessage = sb.toString().replaceAll("\"", "\'");
						map.put("data", reMessage);
					}
					break;
				}
			}
		} catch (Exception e) {
			
		} finally{
			//关闭httpclient连接
			method.releaseConnection();
			client.getHttpConnectionManager().closeIdleConnections(0);
		}
		return JSONObject.parseObject(JSON.toJSONString(map, true));
	}
	
}
