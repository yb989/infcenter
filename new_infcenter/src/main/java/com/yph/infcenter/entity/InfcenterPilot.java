package com.yph.infcenter.entity;

import java.util.Date;

public class InfcenterPilot {
	
	private Integer id;

    private String columnZhName;

    private String columnEnName;

    private String columnUrl;

    private Integer parentId;

    private Integer columnSort;

    private String isEffective;

    private Integer operator;

    private Date operateTime;
    
    private String velocityName;
    
    private String pageSavePath;
    
    private String highlight;//1:高亮
    
	public String getPageSavePath() {
		return pageSavePath;
	}

	public void setPageSavePath(String pageSavePath) {
		this.pageSavePath = pageSavePath;
	}

	public String getVelocityName() {
		return velocityName;
	}

	public void setVelocityName(String velocityName) {
		this.velocityName = velocityName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColumnZhName() {
		return columnZhName;
	}

	public void setColumnZhName(String columnZhName) {
		this.columnZhName = columnZhName;
	}

	public String getColumnEnName() {
		return columnEnName;
	}

	public void setColumnEnName(String columnEnName) {
		this.columnEnName = columnEnName;
	}

	public String getColumnUrl() {
		return columnUrl;
	}

	public void setColumnUrl(String columnUrl) {
		this.columnUrl = columnUrl;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getColumnSort() {
		return columnSort;
	}

	public void setColumnSort(Integer columnSort) {
		this.columnSort = columnSort;
	}

	public String getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	@Override
	public String toString() {
		return "InfcenterPilot [columnEnName=" + columnEnName + ", columnSort="
				+ columnSort + ", columnUrl=" + columnUrl + ", columnZhName="
				+ columnZhName + ", id=" + id + ", isEffective=" + isEffective
				+ ", operateTime=" + operateTime + ", operator=" + operator
				+ ", parentId=" + parentId + ", velocityName=" + velocityName
				+ "]";
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public String getHighlight() {
		return highlight;
	}
	
    
    
}
