package com.mysocket.wstraining.restapi;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysocket.wstraining.regulation.JenkinsDataSorting;
import com.mysocket.wstraining.restapi.models.DashboardDataModel;

@Configuration
@RestController
public class JenkinsDataController {

	@GetMapping("/api")
	public DashboardDataModel[] getRootData() {
		return JenkinsDataSorting.gradeJob(RestMainC.getDashboardDatas());
	}
	
	
}
