package com.mysocket.wstraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.mysocket.wstraining.regulation.JenkinsDataSorting;
import com.mysocket.wstraining.restapi.ClientNotifier;
import com.mysocket.wstraining.restapi.RestMainC;


@SpringBootApplication
@EnableScheduling
public class WsTrainingApplication {
	
	@Autowired
	private SimpMessagingTemplate template; 
	
	public static void main(String[] args) throws InterruptedException {
		
		SpringApplication.run(WsTrainingApplication.class, args);
		
	}
	
	@Scheduled(fixedRate = 5000)
	public void checkData() {
		RestMainC restApi = RestMainC.getInstance();
		restApi.showMeData();
		System.out.println("Check Data fonksiyonu çalıştı");
		int toggle = RestMainC.getNotifyValue();
		if(0==toggle && null!=this.template) {
			this.template.convertAndSend("/topic/jenkinsTracker", RestMainC.getNotifyValue());
		}
		
		
	
		
		
		
	}
	
	
	
}
