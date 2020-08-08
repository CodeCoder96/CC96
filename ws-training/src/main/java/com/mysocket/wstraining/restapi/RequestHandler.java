package com.mysocket.wstraining.restapi;

import com.mysocket.wstraining.restapi.models.Root;

import feign.RequestLine;

public interface RequestHandler {
	
	@RequestLine("GET /job/dev/api/json")
	Root getDevData();
	
	@RequestLine("GET /job/Prod/api/json")
	Root getProdData();
	
	@RequestLine("GET /job/Stable/api/json")
	Root getStableData();
	
	@RequestLine("GET /job/Stage/api/json")
	Root getStageData();
}
