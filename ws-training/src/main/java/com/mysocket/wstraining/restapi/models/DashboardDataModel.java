package com.mysocket.wstraining.restapi.models;

import java.util.Map;

public class DashboardDataModel {
	private String jobName;
	private String devColor;
	private String stableColor;
	private String stageColor;
	private String prodColor;
	private double score;
	
	
	public DashboardDataModel() {
		
	}
	
	public DashboardDataModel(String jobName, String devColor, String stableColor, String stageColor, String prodColor,
			int score) {
		super();
		this.jobName = jobName;
		this.devColor = devColor;
		this.stableColor = stableColor;
		this.stageColor = stageColor;
		this.prodColor = prodColor;
		this.score = score;
	}

	
	
	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public String getDevColor() {
		return devColor;
	}


	public void setDevColor(String devColor) {
		this.devColor = devColor;
	}


	public String getStableColor() {
		return stableColor;
	}


	public void setStableColor(String stableColor) {
		this.stableColor = stableColor;
	}


	public String getStageColor() {
		return stageColor;
	}


	public void setStageColor(String stageColor) {
		this.stageColor = stageColor;
	}


	public String getProdColor() {
		return prodColor;
	}


	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	


	
}
