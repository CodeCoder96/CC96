package com.mysocket.wstraining.restapi.models;

import java.util.List;



public class Root {
	
	
	private String fullName;
	
	
	private String url;
	
	
	private List<Job> jobs;

	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Root [fullName=" + fullName + ", url=" + url + ", jobs=" + jobs + "]";
	}

	
	
}
