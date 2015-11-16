/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: DeleteFileUtil 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-12-25
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yph.infcenter.common.util;

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
 * 2014-12-25 下午03:20:37 DYP         1.0        1.0 Version 
 * </pre>
 */
public class DeleteFileThreadUtil implements Runnable {

	/* (非 Javadoc)
	
	 * <p>Title: run</p>
	 * <p>Description: TODO</p>
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			DeleteFilesUtil.delAllFile(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public DeleteFileThreadUtil(String filePath) {
		this.filePath = filePath;
	}

	@SuppressWarnings("unused")
	private DeleteFileThreadUtil() {
		super();
	}
	
}
