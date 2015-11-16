package com.yph.infcenter.entity;

import java.util.Date;

public class InfcenterInformation {
	
    private Integer id;
	
    private String title;//标题
	
	private String infoSources;//信息来源
	
	private String fileName;//文件名称
	
	private String text;//正文
	
	private Integer clicks;//文件点击数
	
	private Integer operator;//操作人编号
	
	private Date operateTime;//最后操作时间
	
	private String isEffective;//是否有效
	
	private String velocityName;//模板名称
	
	private Integer firstLevelId;//一级站点编号
	
	private Integer websiteId;//菜单站点编号
	
	private Integer secondLevelId;//二级站点编号
	
	private Integer thirdLevelId;//三级站点编号
	
	private Integer fourthLevelId;//四级站点编号
	
	private String encodeFileName;//base64加密后文件名称 
	
	private String isTop;//是否置顶
	
	private String isIndex;//是否缩略
	
	private String indexUrl;//缩略图地址
	
	private String url;//详情地址
	
	private String rowNumber;//取得条数
	
	private String createTime;//新闻创建时间
	
	private String describition;//新闻摘要
	
	public String getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(String isIndex) {
		this.isIndex = isIndex;
	}

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public Integer getThirdLevelId() {
		return thirdLevelId;
	}

	public void setThirdLevelId(Integer thirdLevelId) {
		this.thirdLevelId = thirdLevelId;
	}

	public Integer getFourthLevelId() {
		return fourthLevelId;
	}

	public void setFourthLevelId(Integer fourthLevelId) {
		this.fourthLevelId = fourthLevelId;
	}

	public Integer getFirstLevelId() {
		return firstLevelId;
	}

	public void setFirstLevelId(Integer firstLevelId) {
		this.firstLevelId = firstLevelId;
	}

	public Integer getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(Integer websiteId) {
		this.websiteId = websiteId;
	}

	public Integer getSecondLevelId() {
		return secondLevelId;
	}

	public void setSecondLevelId(Integer secondLevelId) {
		this.secondLevelId = secondLevelId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfoSources() {
		return infoSources;
	}

	public void setInfoSources(String infoSources) {
		this.infoSources = infoSources;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
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

	public String getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	
	public String getEncodeFileName() {
		return encodeFileName;
	}

	public void setEncodeFileName(String encodeFileName) {
		this.encodeFileName = encodeFileName;
	}

	/*
	 * (非 Javadoc)
	
	 * <p>Title: toString</p>
	 * <p>Description: TODO</p>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InfcenterInformation [clicks=" + clicks + ", fileName="
				+ fileName + ", firstLevelId=" + firstLevelId
				+ ", fourthLevelId=" + fourthLevelId + ", id=" + id
				+ ", infoSources=" + infoSources + ", isEffective="
				+ isEffective + ", operateTime=" + operateTime + ", operator="
				+ operator + ", secondLevelId=" + secondLevelId + ", text="
				+ text + ", thirdLevelId=" + thirdLevelId + ", title=" + title
				+ ", velocityName=" + velocityName + ", websiteId=" + websiteId
				+ "]";
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getRowNumber() {
		return rowNumber;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setDescribition(String describition) {
		this.describition = describition;
	}

	public String getDescribition() {
		return describition;
	}
	
}
