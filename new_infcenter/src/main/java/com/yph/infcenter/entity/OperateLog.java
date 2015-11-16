package com.yph.infcenter.entity;

/**
 * 
 *
 * Description: 操作日志实体
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
public class OperateLog extends Entity{
	
    private Integer id;//主键

    private Integer businessObjectId;//业务对象主键id

    private String businessObjectTable;//业务对象表名

    private String businessObjectName;//业务对象名称

    private String operateType;//操作类型

    private String changeOld;//更改前的值

    private String changeNew;//更改后的值

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessObjectId() {
        return businessObjectId;
    }

    public void setBusinessObjectId(Integer businessObjectId) {
        this.businessObjectId = businessObjectId;
    }

    public String getBusinessObjectTable() {
        return businessObjectTable;
    }

    public void setBusinessObjectTable(String businessObjectTable) {
        this.businessObjectTable = businessObjectTable == null ? null : businessObjectTable.trim();
    }

    public String getBusinessObjectName() {
        return businessObjectName;
    }

    public void setBusinessObjectName(String businessObjectName) {
        this.businessObjectName = businessObjectName == null ? null : businessObjectName.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public String getChangeOld() {
        return changeOld;
    }

    public void setChangeOld(String changeOld) {
        this.changeOld = changeOld == null ? null : changeOld.trim();
    }

    public String getChangeNew() {
        return changeNew;
    }

    public void setChangeNew(String changeNew) {
        this.changeNew = changeNew == null ? null : changeNew.trim();
    }
}