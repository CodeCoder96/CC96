package com.mysocket.wstraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession;
import org.springframework.web.util.HtmlUtils;

import com.mysocket.wstraining.restapi.RestMainC;

@Controller
public class EnvelopeController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Scheduled(fixedRate = 5000)
	public void informClients() {
		switch(RestMainC.getNotifyValue()) {
		case -1:
			this.template.convertAndSend("/topic/jenkinsTracker", "Servis yeni başladı, Sistem ayağa kalkıyor.");
			break;
		case 0:
			this.template.convertAndSend("/topic/jenkinsTracker"," Değerler değişti. Yeni değerler : " + RestMainC.getJenkinsDatas());
			break;
		case 1:
			this.template.convertAndSend("/topic/jenkinsTracker", "Değerler Aynı. Her şey düzgün çalışıyor");
			break;
		case 2:
			this.template.convertAndSend("/topic/jenkinsTracker", "Henüz jenkinsten veriler çekilmedi veya jenkins verileri çekilirken hata oluştu");
			break;
		}
		
	}
	 
	/*@MessageMapping("/changed-values")
	@SendTo("/topic/jenkinsTracker")
	public Envelope envelope(Notice notice) throws Exception {
		Thread.sleep(1000);
		
		return new Envelope(HtmlUtils.htmlEscape(notice.getNotice()));
	}*/
}
