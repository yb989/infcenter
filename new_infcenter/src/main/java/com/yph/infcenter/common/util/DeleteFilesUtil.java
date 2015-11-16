/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: DeleteFilesUtil.java 
 *
 * Created: [2014-12-25 下午03:09:34] by suxuqiang 
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

package com.yph.infcenter.common.util;

import java.io.File;
import java.util.List;

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
 * 2014-12-25    suxuqiang       1.0        1.0 Version 
 * </pre>
 */

public class DeleteFilesUtil {
	/**
	 * 
	 * Description: 输入一个URL，删除list之外的所有文件
	 *
	 * @param path :根路径
	 * @param list :需要保留的文件名称（包含文件后缀名）；如果是文件夹，直接输入文件名即可;直接输入null，会删除路径下所有文件
	 * @return void
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-25 下午04:33:25
	 */
	public static void removeFiles(String path, List<String> list) throws Exception {		
		if(path==null||path.equals("")){
			throw new Exception("路径不存在");
		}
		File root = new File(path);					
		if(!root.exists()){
			throw new Exception("文件夹不存在");
		}		
		File[] files = root.listFiles();							
		for (File file : files) {
			if(null==list){
				if(file.isDirectory()){
					removeFiles(file.getAbsolutePath(),list);
					if(file.listFiles().length==0){
						file.delete();
					}
				}else{					
					file.delete();					
				}				
			}else{
				if(file.isDirectory()){
					if(!list.contains(file.getName())){
						removeFiles(file.getAbsolutePath(),list);
						if(file.listFiles().length==0){
							file.delete();
						}
					}
				}else{
					if(!list.contains(file.getName())){
						file.delete();
					}
				}
			}
		}
	}
	
	/**
	  *  
	  * @Description: 删除指定的某个文件，如c:\\java\\img，则只删除img
	  *
	  * @param		文件夹完整绝对路径
	  * @return void
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-25 下午05:33:47
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	  * 
	  * @Description: 删除指定文件夹下所有文件，包括子文件夹
	  *
	  * @param        文件目录，如c:\\java\\test1\\test2
	  * @return boolean
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-25 下午05:30:03
	 */
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}
}
