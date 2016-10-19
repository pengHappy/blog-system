package com.hp.common;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.FactoryBean;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactoryBean implements FactoryBean<ObjectMapper>{

	@Override
	public ObjectMapper getObject() throws Exception {
		return new ObjectMapper()
		.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")) ;
	}

	@Override
	public Class<?> getObjectType() {
		return ObjectMapper.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	

}
