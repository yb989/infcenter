/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: DeleteFilesTest.java 
 *
 * Created: [2014-12-25 下午03:52:21] by suxuqiang 
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

package com.yph.infcenter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.yph.infcenter.common.util.DeleteFilesUtil;

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

public class DeleteFilesTest {
	
	@Test
	public void deleteFiles(){
		String path="D:/installation/Workspaces/MyEclipse 8.6/infcenter/WebRoot/image";
		List<String> list = new ArrayList<String>();
		list.add("ajax-loader.gif");
		list.add("file1");
		try {
			DeleteFilesUtil.removeFiles(path, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
