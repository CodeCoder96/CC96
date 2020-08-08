package com.mysocket.wstraining.restapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysocket.wstraining.restapi.models.Job;
import com.mysocket.wstraining.restapi.models.Root;

public class RestMainC {
	

	private static final String ID = "admin";
	private static final String PASS = "11798374e7960d9e150f145c577b950e68";
	
	private static List<Root> jenkinsDatas;
	
	
	public void showMeData() throws Exception {
		JenkinsDataService service = JenkinsDataService.getInstance();
		service.startService(ID, PASS);
		
		jenkinsDatas = new ArrayList<Root>();
		jenkinsDatas.add(service.getDevData());
		jenkinsDatas.add(service.getProdData());
		jenkinsDatas.add(service.getStableData());
		jenkinsDatas.add(service.getStageData());
		
	}

	public static List<Root> getJenkinsDatas() {
		return jenkinsDatas;
	}

	

	
}
