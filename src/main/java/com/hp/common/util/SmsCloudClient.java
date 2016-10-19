package com.hp.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;



public class SmsCloudClient {
	private static Logger logger = Logger.getLogger(SmsCloudClient.class);
	private String reqUrl;
	
	private HttpClient httpClient;
	private static String BASE_URI = "http://yunpian.com";
	
	private  String apiKey;
	/**
	 * 服务版本号
	 */
	private static String VERSION = "v1";
	/**
	 * 编码格式
	 */
	private static String ENCODING = "UTF-8";
	/**
	 * 通用发送接口的http地址
	 */
	private static String URI_SEND_SMS = BASE_URI + "/" + VERSION + "/sms/send.json";

	/*
	public void init(){
		HttpClient client = new HttpClient();
	}*/
	
	public String getReqUrl() {
		return reqUrl;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	public HttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public  String sendSms(String text, String mobile) throws IOException{		
		NameValuePair[] nameValuePairs = new NameValuePair[3];
		nameValuePairs[0] = new NameValuePair("apikey", apiKey);
		nameValuePairs[1] = new NameValuePair("text", text);
		nameValuePairs[2] = new NameValuePair("mobile", mobile);
		PostMethod method = new PostMethod(URI_SEND_SMS);
		method.setRequestBody(nameValuePairs);
		HttpMethodParams param = method.getParams();
		param.setContentCharset(ENCODING);
		httpClient.executeMethod(method);
		String json=method.getResponseBodyAsString();	
		return json;
	}
	
	public static void main(String[] args) throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		String json="{\"code\":0,\"msg\":\"OK\",\"result\":[{\"count\":1,\"fee\":1,\"sid\":778723022}]}";
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> map = mapper.readValue(json, LinkedHashMap.class);
		map.get("result");
	}
	
	public static class SMSSendRet{
	private int code;
	private String msg;
	private String detail;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
	

	public String post(String json) {
		// TODO Auto-generated method stub
		return post(json,this.reqUrl);
	}
	/*json是post内容，可以是一段文本字符串*/
	public String post(String json, String url) {
		return post("application/json",json,url);
	}
	
	public String post(String contentType,String json,String url){
		//System.out.println("你好****************************非常好*****************");	
		PostMethod postMethod = new PostMethod(url);	
		byte[] bytes = {};
		try {
			bytes = json.getBytes("utf-8");
		} catch (UnsupportedEncodingException e1) {
		}
		Header header = new Header();
		header.setName("Content-Type");
		header.setName(contentType);
		postMethod.setRequestHeader(header);
		if (logger.isDebugEnabled()) {
			logger.debug("请求json:\n" + json);
		}
		StringBuilder resSb=new StringBuilder();
		try {
			postMethod.setRequestEntity(new ByteArrayRequestEntity(bytes,
					"application/json; charset=UTF-8"));
			if (logger.isDebugEnabled()) {				
				logger.debug("开始请求:" + url + " \n 消息");				
				//logger.debug("开始请求消息....");
			}
			System.out.println("开始请求:" + url + " \n 消息");
			int statuscode = httpClient.executeMethod(postMethod);
			if (statuscode == HttpStatus.SC_OK) {
				InputStream sis = postMethod.getResponseBodyAsStream();
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				IOUtils.copy(sis, byteArrayOutputStream);
				if (logger.isDebugEnabled()) {
					//logger.debug("请求返回状态:" + statuscode);
					//System.out.println("请求返回状态:" + statuscode);
				}
				System.out.println("请求返回状态:" + statuscode);
				resSb = new StringBuilder(new String(
						byteArrayOutputStream.toByteArray(), "utf-8"));
					//System.out.println("应答xml:\n" + resSb.toString());
					//logger.debug("应答xml:\n" + resSb.toString());
				
				//res= BaseCoder.decodeRes(messageManager, resSb);
			}else{
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resSb.toString() ;	
	}

	


	
	public String get() {
		// TODO Auto-generated method stub
		return get(this.reqUrl);
	}

	
	public String get(String url) {
		GetMethod getMethod = new GetMethod(url);	
		
		Header header = new Header();
		header.setName("Content-Type");
		header.setName("application/json");
		getMethod.setRequestHeader(header);
		if (logger.isDebugEnabled()) {
			logger.debug("请求url:\n" + url);
		}
		StringBuilder resSb=new StringBuilder();
		try {
			
			int statuscode = httpClient.executeMethod(getMethod);
			if (statuscode == HttpStatus.SC_OK) {
				InputStream sis = getMethod.getResponseBodyAsStream();
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				IOUtils.copy(sis, byteArrayOutputStream);
				if (logger.isDebugEnabled()) {
					logger.debug("请求返回状态:" + statuscode);
				}
				resSb = new StringBuilder(new String(
						byteArrayOutputStream.toByteArray(), "utf-8"));
				if (logger.isDebugEnabled()) {
					//logger.debug("应答json:\n" + resSb.toString());
				}
				//res= BaseCoder.decodeRes(messageManager, resSb);
			}else{
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resSb.toString() ;	
	}
}
