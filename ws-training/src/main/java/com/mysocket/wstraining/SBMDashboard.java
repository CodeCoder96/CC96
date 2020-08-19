package com.mysocket.wstraining;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;


import com.mysocket.wstraining.regulation.JenkinsDataSorting;
import com.mysocket.wstraining.restapi.RestMainC;
import com.mysocket.wstraining.restapi.models.DashboardDataModel;

@Component
public class SBMDashboard implements CommandLineRunner {

	private static final String SUBSRCRIBE_MAIN_CHANNEL = "/topic/jenkinsTracker";
	
	
	
	@Autowired
	private static SimpMessagingTemplate template; 

	public static void publish() {

		//DashboardDataModel[] dataModels = JenkinsDataSorting.gradeJob(RestMainC.getDashboardDatas());
		System.out.println("Publish çalıştı");
		template.convertAndSend(SUBSRCRIBE_MAIN_CHANNEL, RestMainC.getNotifyValue());
	}

	@Override
	public void run(String... args) throws Exception {
		//Thread.sleep(2000L);
		//publish();

	}

	public static SimpMessagingTemplate getTemplate() {
		return template;
	}

}
