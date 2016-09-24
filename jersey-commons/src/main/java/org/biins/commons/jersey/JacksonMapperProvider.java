package org.biins.commons.jersey;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.JsonViewSerializer;

@Provider
public class JacksonMapperProvider implements ContextResolver<ObjectMapper> {

	@Override
	public ObjectMapper getContext(Class<?> type) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(createJsonViewModule());
		return objectMapper;
	}

	private Module createJsonViewModule() {
		SimpleModule module = new SimpleModule();
		module.addSerializer(JsonView.class, new JsonViewSerializer());
		return module;
	}
}
