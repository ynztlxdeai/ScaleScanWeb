package com.moyansz.common;


import com.moyansz.properties.SystemConfig;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import shaded.org.apache.http.HttpEntity;
import shaded.org.apache.http.NameValuePair;
import shaded.org.apache.http.client.HttpClient;
import shaded.org.apache.http.client.entity.UrlEncodedFormEntity;
import shaded.org.apache.http.client.methods.HttpPost;
import shaded.org.apache.http.entity.StringEntity;
import shaded.org.apache.http.message.BasicNameValuePair;


public class HttpSenderBase {
	static         Logger     logger     = Logger.getLogger(HttpSenderBase.class);
	private static Properties config     = new Properties();
	public static  HttpClient httpClient = null;
	
	public static HttpPost buildPost(HttpEntity paramsEntity, String url){
		HttpPost httpPost = new HttpPost(url);

		httpPost.setEntity(paramsEntity);
		
		return httpPost;
	}
	
	public static HttpPost buildPostWithHeadInfo(HttpEntity paramsEntity, String url){
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(paramsEntity);
		httpPost.setHeader(SystemConfig.meridKey, SystemConfig.meridValue);
		httpPost.setHeader(SystemConfig.domainNameKey, SystemConfig.domainNameValue);
		return httpPost;
	}
	
	public static HttpPost buildPostJson(StringEntity paramsEntity, String url){
		HttpPost httpPost = new HttpPost(url);
		
		httpPost.setEntity(paramsEntity);
		
		return httpPost;
	}
	
	
	public static List<NameValuePair> buildPrams(Map<String, String> params){
		List<NameValuePair> tl = new ArrayList<NameValuePair>();
		if(params == null || params.size() < 1) return null;
		for(Iterator<Entry<String, String>> iterator = params.entrySet().iterator(); iterator.hasNext();){
			Entry<String, String> param = iterator.next();
			tl.add(new BasicNameValuePair(param.getKey(), param.getValue()));
		}
		return tl;
	}
	
	public static HttpEntity buildHttpEntity(Map<String, String> params, String encode){
		HttpEntity httpEntity = null;
		try {
			httpEntity = new UrlEncodedFormEntity(buildPrams(params), encode);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}
		return httpEntity;
	}
	
	
	
}
