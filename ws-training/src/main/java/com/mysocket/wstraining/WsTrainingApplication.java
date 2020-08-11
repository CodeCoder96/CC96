package com.mysocket.wstraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import com.mysocket.wstraining.restapi.RestMainC;


@SpringBootApplication
@EnableScheduling
public class WsTrainingApplication {
	

	
	public static void main(String[] args) {
		
		SpringApplication.run(WsTrainingApplication.class, args);
		
	}
	
	@Scheduled(fixedRate = 5000)
	public void checkData() throws Exception {
		RestMainC restApi = new RestMainC();
		restApi.showMeData();
		
		
	}
	
	
	
}
