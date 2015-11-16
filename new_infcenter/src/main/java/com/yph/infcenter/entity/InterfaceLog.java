package com.yph.infcenter.entity;

/**
 * 
 *
 * Description: 接口日志实体
 *
 * @author ydw
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-11    ydw       1.0        1.0 Version 
 * </pre>
 */
@SuppressWarnings("serial")
public class InterfaceLog extends Entity{
	
    private Integer id;//主键id

    private String systemIdentifying;//系统标识  核心系统:''HXXT''

    private String interfaseDescription;//接口功能描述

    private String interfaseData;//接口传输数据

    private String operState;//操作状态  false:失败，true:成功

    private String isCallBack;//是否是回调接口  是:''1'', 不是:''0''

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystemIdentifying() {
        return systemIdentifying;
    }

    public void setSystemIdentifying(String systemIdentifying) {
        this.systemIdentifying = systemIdentifying == null ? null : systemIdentifying.trim();
    }

    public String getInterfaseDescription() {
        return interfaseDescription;
    }

    public void setInterfaseDescription(String interfaseDescription) {
        this.interfaseDescription = interfaseDescription == null ? null : interfaseDescription.trim();
    }

    public String getInterfaseData() {
        return interfaseData;
    }

    public void setInterfaseData(String interfaseData) {
        this.interfaseData = interfaseData == null ? null : interfaseData.trim();
    }

    public String getOperState() {
        return operState;
    }

    public void setOperState(String operState) {
        this.operState = operState == null ? null : operState.trim();
    }

    public String getIsCallBack() {
        return isCallBack;
    }

    public void setIsCallBack(String isCallBack) {
        this.isCallBack = isCallBack == null ? null : isCallBack.trim();
    }
}