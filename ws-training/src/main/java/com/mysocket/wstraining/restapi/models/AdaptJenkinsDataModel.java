package com.mysocket.wstraining.restapi.models;

public class AdaptJenkinsDataModel {
	private String parentJonName;
	private String jobName;
	private String url;
	private String buildColor;
	
	

	public AdaptJenkinsDataModel(String parentJonName, String jobName, String url, String buildColor) {
		super();
		this.parentJonName = parentJonName;
		this.jobName = jobName;
		this.url = url;
		this.buildColor = buildColor;
	}

	public String getParentJonName() {
		return parentJonName;
	}

	public void setParentJonName(String parentJonName) {
		this.parentJonName = parentJonName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBuildColor() {
		return buildColor;
	}

	public void setBuildColor(String buildColor) {
		this.buildColor = buildColor;
	}
	
	
}
