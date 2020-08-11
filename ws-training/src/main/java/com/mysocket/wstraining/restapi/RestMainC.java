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
	private static List<Root> newestJenkinsData;
	private static int notifyValue=2;
	
	public void showMeData() throws Exception {
		JenkinsDataService service = JenkinsDataService.getInstance();
		service.startService(ID, PASS);
		
		newestJenkinsData = new ArrayList<Root>();
		newestJenkinsData.add(service.getDevData());
		newestJenkinsData.add(service.getProdData());
		newestJenkinsData.add(service.getStableData());
		newestJenkinsData.add(service.getStageData());
		
		ClientNotifier notifier = new ClientNotifier();
		
		notifyValue=notifier.isNotifiable(jenkinsDatas, newestJenkinsData);
			
		
		
		jenkinsDatas = new ArrayList<Root>();
		jenkinsDatas.add(service.getDevData());
		jenkinsDatas.add(service.getProdData());
		jenkinsDatas.add(service.getStableData());
		jenkinsDatas.add(service.getStageData());
		
	}

	public static int getNotifyValue() {
		return notifyValue;
	}

	public static List<Root> getJenkinsDatas() {
		return jenkinsDatas;
	}

	

	
}
