package com.mysocket.wstraining.restapi;

import com.mysocket.wstraining.restapi.models.Root;

import feign.Feign;

import feign.auth.BasicAuthRequestInterceptor;
import feign.gson.GsonDecoder;

public class JenkinsDataService {

	private static final JenkinsDataService service = new JenkinsDataService();

	private Root devData;
	private Root prodData;
	private Root stableData;
	private Root stageData;

	public static JenkinsDataService getService() {
		return service;
	}

	public Root getProdData() {
		return prodData;
	}

	public Root getStableData() {
		return stableData;
	}

	public Root getStageData() {
		return stageData;
	}

	public Root getDevData() {
		return devData;
	}

	public static JenkinsDataService getInstance() {
		return service;
	}

	public void startService(String id, String pass) throws Exception {
		RequestHandler requestHandler = Feign.builder().requestInterceptor(new BasicAuthRequestInterceptor(id, pass))
				.decoder(new GsonDecoder()).target(RequestHandler.class, "http://localhost:2000");

		devData = requestHandler.getDevData();
		prodData = requestHandler.getProdData();
		stableData = requestHandler.getStableData();
		stageData = requestHandler.getStageData();
		
	}
}
