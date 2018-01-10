package com.moyansz.common;

import com.moyansz.properties.SystemConfig;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import shaded.org.apache.http.HttpEntity;
import shaded.org.apache.http.HttpResponse;
import shaded.org.apache.http.client.ClientProtocolException;
import shaded.org.apache.http.client.methods.HttpPost;
import shaded.org.apache.http.client.methods.HttpUriRequest;
import shaded.org.apache.http.entity.StringEntity;
import shaded.org.apache.http.impl.client.DefaultHttpClient;
import shaded.org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class HttpSenderUtil extends HttpSenderBase {

	/**
	 * 调用接口方法
	 * 
	 * @param paramsMap
	 * @param Url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> reuquestUrl(Map<String, String> paramsMap, String url) {
		HttpEntity          httpEntity    = buildHttpEntity(paramsMap, SystemConfig.CHARSET_ENCODE);
		HttpPost            httpPost      = buildPost(httpEntity, url);
		HttpResponse        httpResoponse = post(httpPost);
		Map<String, Object> resultMap     = null;
		StringBuffer        sb            = new StringBuffer();
		try {
			if (null != httpResoponse) {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(httpResoponse.getEntity().getContent(), "UTF-8"));
				String lineData = br.readLine();
				while (!StringUtils.isEmpty(lineData)) {
					sb.append(lineData);
					lineData = br.readLine();
				}
				if (sb.toString().isEmpty()) {
					resultMap = new HashMap<String, Object>();
					resultMap.put("rsCode", 404);
					resultMap.put("rsMsg", "找不到对应的接口");
					return resultMap;
				}
				// resultMap = (HashMap<String, String>)new
				// JSONParser().parse(sb.toString());
				resultMap = (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(sb.toString()),
						HashMap.class);
			} else {
				throw new Exception("调用失败");
			}
		} catch (Exception e) {
			logger.error(e);
		} finally {
			httpPost.releaseConnection();
		}
		return resultMap;
	}

	/**
	 * 调用接口方法
	 * 
	 * @param paramsMap
	 * @param Url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> reuquestUrl(Map<String, String> paramsMap, String url,
			Map<String, Class<?>> clazzMap) {
		HttpEntity httpEntity = buildHttpEntity(paramsMap, SystemConfig.CHARSET_ENCODE);
		HttpPost httpPost = buildPost(httpEntity, url);
		HttpResponse httpResoponse = post(httpPost);
		Map<String, Object> resultMap = null;
		StringBuffer sb = new StringBuffer();
		try {
			if (null != httpResoponse) {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(httpResoponse.getEntity().getContent(), "UTF-8"));
				String lineData = br.readLine();
				while (!StringUtils.isEmpty(lineData)) {
					sb.append(lineData);
					lineData = br.readLine();
				}
				resultMap = (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(sb.toString()), HashMap.class,
						clazzMap);
			} else {
				throw new Exception("调用失败");
			}
		} catch (Exception e) {
			logger.info(e);
			logger.error(e);
		} finally {
			httpPost.releaseConnection();
		}
		return resultMap;
	}

	public static <T> com.moyansz.vo.ComplexData<T> reuquestUrlStr(Map<String, String> paramsMap, String url) {
		HttpEntity                  httpEntity    = buildHttpEntity(paramsMap, SystemConfig.CHARSET_ENCODE);
		HttpPost                    httpPost      = buildPostWithHeadInfo(httpEntity, url);
		HttpResponse                httpResoponse = post(httpPost);
		com.moyansz.vo.ComplexData<T> response      = null;
		try {
			String responseContent = EntityUtils.toString(httpResoponse.getEntity(), "UTF-8");
			System.out.println("httpclient请求获取返回数据:" + responseContent);
			EntityUtils.consume(httpResoponse.getEntity());
			// resultMap = (Map<String,
			// String>)JSONObject.toBean(JSONObject.fromObject(responseContent),
			// HashMap.class);
			response = (com.moyansz.vo.ComplexData<T>) JSONObject.toBean(JSONObject.fromObject(responseContent), com.moyansz.vo.ComplexData.class);
		} catch (IllegalStateException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			httpPost.releaseConnection();
		}
		return response;
	}

	public static String reuquestUrlStrResponse(Map<String, String> paramsMap, String url) {
		HttpEntity httpEntity = buildHttpEntity(paramsMap, SystemConfig.CHARSET_ENCODE);
		HttpPost httpPost = buildPostWithHeadInfo(httpEntity, url);
		HttpResponse httpResoponse = post(httpPost);
		String responseContent = null;
		try {
			responseContent = EntityUtils.toString(httpResoponse.getEntity(), "UTF-8");
			EntityUtils.consume(httpResoponse.getEntity());
		} catch (IllegalStateException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			httpPost.releaseConnection();
		}
		return responseContent;
	}

	/**
	 * 调用接口方法
	 * 
	 * @param paramsMap
	 * @param Url
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, String> postUrlJson(String jsonStr, String url) throws UnsupportedEncodingException {
		// HttpEntity httpEntity = buildHttpEntity(paramsMap,
		// SycnAccountDef.charSet_encode);
		StringEntity parmStr = new StringEntity(jsonStr);
		parmStr.setContentEncoding("UTF-8");
		parmStr.setContentType("application/json");
		HttpPost httpPost = buildPostJson(parmStr, url);
		HttpResponse httpResoponse = post(httpPost);
		Map<String, String> resultMap = null;
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(httpResoponse.getEntity().getContent()));
			String lineData = br.readLine();
			while (!StringUtils.isEmpty(lineData)) {
				sb.append(lineData);
				lineData = br.readLine();
			}
			// resultMap = (HashMap<String, String>)new
			// JSONParser().parse(sb.toString());
			resultMap = (Map<String, String>) JSONObject.toBean(JSONObject.fromObject(sb.toString()), HashMap.class);
		} catch (IllegalStateException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			httpPost.releaseConnection();
		}
		return resultMap;
	}

	public static HttpResponse post(HttpUriRequest post) {
		httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(post);
		} catch (ClientProtocolException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return httpResponse;
	}

	
}
