/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: DateSpringUtilCon.java 
 *
 * Created: [2014-12-1 下午03:56:21] by ydw 
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
 * ProjectName: sping-mvc 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yph.infcenter.common.util;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * 
 * Description:
 *  表单向Controller传参时，Spring对日期的处理类。
 *	其默认的类存在问题，无法处理空的日期，因此这里
 *	写一个自定义的处理类。
 * 
 * @author ydw
 * @version 1.0
 * 
 *<pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-1    ydw       1.0        1.0 Version
 * </pre>
 */
public class DateEditor extends PropertyEditorSupport {

	private static final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private DateFormat dateFormat;

	private boolean allowEmpty = true;

	public DateEditor() {
		
	}

	public DateEditor(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public DateEditor(DateFormat dateFormat, boolean allowEmpty) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		} else {
			try {
				if (this.dateFormat != null) {
					setValue(this.dateFormat.parse(text));
				} else {
					if (text.contains(":")) {
						setValue(TIMEFORMAT.parse(text));
					} else {
						setValue(DATEFORMAT.parse(text));
					}
				}
			} catch (ParseException ex) {
				throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
			}
		}
	}

	@Override
	public String getAsText() {
		Date value = (Date) getValue();
		DateFormat dateFormat = this.dateFormat;
		if (dateFormat == null) {
			dateFormat = TIMEFORMAT;
		}
		return (value != null ? dateFormat.format(value) : "");
	}
}
