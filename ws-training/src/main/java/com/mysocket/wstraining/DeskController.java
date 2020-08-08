package com.mysocket.wstraining;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@Controller
public class DeskController {
	
	@MessageMapping("/classA")
	@SendTo("/topic/class")
	public Desk desk(Student student) throws Exception {
		Thread.sleep(1000);
		return new Desk(HtmlUtils.htmlEscape(student.getName())+" adlı öğrenci sırasına oturdu.");
	}
	
	
}
