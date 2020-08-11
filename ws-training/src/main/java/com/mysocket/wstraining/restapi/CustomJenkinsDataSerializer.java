package com.mysocket.wstraining.restapi;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.mysocket.wstraining.restapi.models.Root;

public class CustomJenkinsDataSerializer extends StdSerializer<Root>{

	
	private static final long serialVersionUID = 1L;

	public CustomJenkinsDataSerializer() {
		this(null);
	}
	
	public CustomJenkinsDataSerializer(Class<Root> root) {
		super(root);
	}

	@Override
	public void serialize(Root value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.useDefaultPrettyPrinter();
		
	}
	
}
