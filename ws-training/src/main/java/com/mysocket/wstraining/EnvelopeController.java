package com.mysocket.wstraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.mysocket.wstraining.restapi.RestMainC;

@Controller
public class EnvelopeController {
	
	private static final String SUBSRCRIBE_CHANNEL = "/topic/jenkinsTracker";

	
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Scheduled(fixedRate = 5000)
	public void informClients() {
		
		
		/*switch(RestMainC.getNotifyValue()) {
		case -1:
			this.template.convertAndSend(SUBSRCRIBE_CHANNEL, "Merhaba");
			break;
		case 0:
			this.template.convertAndSend(SUBSRCRIBE_CHANNEL," Değerler değişti. Yeni değerler : " );
			break;
		case 1:
			this.template.convertAndSend(SUBSRCRIBE_CHANNEL, "Değerler Aynı. Her şey düzgün çalışıyor. Değerler : ");
			break;
		default:
			this.template.convertAndSend(SUBSRCRIBE_CHANNEL, "Henüz jenkinsten veriler çekilmedi veya jenkins verileri çekilirken hata oluştu");
			break;
		}*/
		
		
	}

	
	


	

	 
	
}
