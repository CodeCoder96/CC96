package com.mysocket.wstraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.mysocket.wstraining.restapi.RestMainC;


@SpringBootApplication
@EnableScheduling
public class WsTrainingApplication {
	private static final String SUBSRCRIBE_CHANNEL = "/topic/jenkinsTracker";
	@Autowired
	private SimpMessagingTemplate template; 
	
	public static void main(String[] args) throws InterruptedException {
		
		SpringApplication.run(WsTrainingApplication.class, args);
		
	}
	
	@Scheduled(fixedRate = 5000)
	public void checkData() {
		RestMainC restApi = RestMainC.getInstance();
		restApi.showMeData();
		int toggle = RestMainC.getNotifyValue();
		if(0==toggle && null!=this.template) {
			this.template.convertAndSend(SUBSRCRIBE_CHANNEL, RestMainC.getNotifyValue());
		}
		
		
	
		
		
		
	}
	
	
	
}
