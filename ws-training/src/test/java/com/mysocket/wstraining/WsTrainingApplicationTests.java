package com.mysocket.wstraining;



import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class WsTrainingApplicationTests {

	@Test
	void contextLoads() throws Exception {
		
		Random rndm = new Random();
		switch (rndm.nextInt(1)) {
		case 1:
			Assert.assertTrue(4!=2+1);
			break;

		default:
			Assert.assertTrue(4==2+1);
			break;
		}
		
	
		

	}

	
	
}
