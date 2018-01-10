package com.moyansz.common;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import shaded.org.apache.http.HttpEntity;
import shaded.org.apache.http.HttpResponse;
import shaded.org.apache.http.NameValuePair;
import shaded.org.apache.http.ParseException;
import shaded.org.apache.http.client.ClientProtocolException;
import shaded.org.apache.http.client.HttpClient;
import shaded.org.apache.http.client.entity.UrlEncodedFormEntity;
import shaded.org.apache.http.client.methods.HttpGet;
import shaded.org.apache.http.client.methods.HttpPost;
import shaded.org.apache.http.client.utils.URLEncodedUtils;
import shaded.org.apache.http.conn.scheme.Scheme;
import shaded.org.apache.http.conn.ssl.SSLSocketFactory;
import shaded.org.apache.http.entity.StringEntity;
import shaded.org.apache.http.impl.client.DefaultHttpClient;
import shaded.org.apache.http.message.BasicNameValuePair;
import shaded.org.apache.http.protocol.HTTP;
import shaded.org.apache.http.util.EntityUtils;


/**
 * @description:http工具类
 * @fileName:HttpClientUtils.java
 * @createTime:2014年8月5日 下午3:13:26
 * @author:lilong
 * @version 1.0.0
 * 
 */
public class HttpClientUtils
{
	
	private static Logger log = Logger.getLogger(HttpClientUtils.class);
	
	public static void main(String[] args)
	{
		String reqURL = "http://localhost:8080/restservice/rest/api/test/1";
		String decodeCharset = "utf-8";
		System.out.println(HttpClientUtils
				.sendGetRequest(reqURL, decodeCharset));
	}
	
	/**
	 * 
	 * @function: http get请求方法
	 * @param url
	 * @return String
	 * @exception
	 * @author:lilong
	 * @since 1.0.0
	 */
	public static String httpGet(String url)
	{
		return sendGetRequest(url, "utf-8");
	}
	
	/**
	 * 
	 * @function:发送HTTP_GET请求  
	 * @param reqURL请求地址(含参数)
	 * @param decodeCharset解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
	 * @return String 远程主机响应正文  
	 * @exception 
	 * @author:lilong   
	 * @since  1.0.0
	 */
	public static String sendGetRequest(String reqURL, String decodeCharset)
	{
		long       responseLength  = 0; // 响应长度
		String     responseContent = null; // 响应内容
		HttpClient httpClient      = new DefaultHttpClient(); // 创建默认的httpClient实例
		HttpGet    httpGet         = new HttpGet(reqURL); // 创建org.apache.http.client.methods.HttpGet
		try
		{
			HttpResponse response = httpClient.execute(httpGet); // 执行GET请求
			HttpEntity   entity   = response.getEntity(); // 获取响应实体
			if (null != entity)
			{
				responseLength = entity.getContentLength();
				responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity); // Consume response content
			}
			System.out.println("请求地址: " + httpGet.getURI());
			System.out.println("响应状态: " + response.getStatusLine());
			System.out.println("响应长度: " + responseLength);
			System.out.println("响应内容: " + responseContent);
		}
		catch (ClientProtocolException e)
		{
			log.error(
					"该异常通常是协议错误导致,比如构造HttpGet对象时传入的协议不对(将'http'写成'htp')或者服务器端返回的内容不符合HTTP协议要求等,堆栈信息如下",
					e);
		}
		catch (ParseException e)
		{
			log.error(e.getMessage(), e);
		}
		catch (IOException e)
		{
			log.error("该异常通常是网络原因引起的,如HTTP服务器未启动等,堆栈信息如下", e);
		}
		finally
		{
			httpClient.getConnectionManager().shutdown(); // 关闭连接,释放资源
		}
		return responseContent;
	}
	
	
	/**
	 * 
	 * @function: 发送HTTP_POST请求 
	 * @param reqURL
	 * @param sendData
	 * @param isEncoder用于指明请求数据是否需要UTF-8编码,true为需要
	 * @return String   
	 * @exception 
	 * @author:lilong   
	 * @since  1.0.0
	 */
	public static String sendPostRequest(String reqURL, String sendData,
			boolean isEncoder)
	{
		return sendPostRequest(reqURL, sendData, isEncoder, null, null);
	}
	
	
	/**
	 * 
	 * @function: http post请求 
	 * @param url 请求地址
	 * @param params提交参数，格式如下：a=1&b=1
	 * @return String  返回结果 
	 * @exception 
	 * @author:lilong   
	 * @since  1.0.0
	 */
	public static String httpPost(String url, String params)
	{
		return sendPostRequest(url, params, true);
	}
	public static String httpPost(String reqURL,
			Map<String, String> params)
	{
		return sendPostRequest(reqURL, params, null, null);
	}
	
	/**
	 * 
	 * @function: 发送HTTP_POST请求 
	 * @param reqURL请求地址
	 * @param sendData 请求参数
	 * @param isEncoder 请求数据是否需要encodeCharset编码,true为需要
	 * @param encodeCharset 编码字符集,编码请求数据时用之,其为null时默认采用UTF-8解码
	 * @param decodeCharset 解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
	 * @return String 远程主机响应正文  
	 * @exception 
	 * @author:lilong   
	 * @since  1.0.0
	 */
	public static String sendPostRequest(String reqURL, String sendData,
			boolean isEncoder, String encodeCharset, String decodeCharset)
	{
		String     responseContent = null;
		HttpClient httpClient      = new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost(reqURL);
		// httpPost.setHeader(HTTP.CONTENT_TYPE,
		// "application/x-www-form-urlencoded; charset=UTF-8");
		httpPost.setHeader(HTTP.CONTENT_TYPE,
						   "application/x-www-form-urlencoded");
		try
		{
			if (isEncoder)
			{
				List<NameValuePair> formParams = new ArrayList<NameValuePair>();
				for (String str : sendData.split("&"))
				{
					formParams.add(new BasicNameValuePair(str.substring(0,
																		str.indexOf("=")),
														  str.substring(str.indexOf("=") + 1)));
				}
				httpPost.setEntity(new StringEntity(URLEncodedUtils.format(
						formParams, encodeCharset == null ? "UTF-8"
								: encodeCharset)));
			}
			else
			{
				httpPost.setEntity(new StringEntity(sendData));
			}
			
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity   entity   = response.getEntity();
			if (null != entity)
			{
				responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		}
		catch (Exception e)
		{
			log.error("与[" + reqURL + "]通信过程中发生异常,堆栈信息如下", e);
		}
		finally
		{
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}
	
	
	/**
	 * http post JSON
	 * @param reqURL
	 * @param sendData
	 * @param isEncoder
	 * @param encodeCharset
	 * @param decodeCharset
	 * @return
	 * @throws Exception 
	 */
	public static String sendPostJsonRequest(String reqURL, String sendJsonData) throws Exception {
		log.info("http url: "+ reqURL);
		log.info("http para: "+ sendJsonData);
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(reqURL);
		httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
		try {
			httpPost.setEntity(new StringEntity(sendJsonData,"UTF-8"));
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity, "UTF-8");
				log.info("http para: "+ responseContent); 
				EntityUtils.consume(entity);
			}
		} catch (Exception e) {
			log.info("http err: ",e); 
			throw new Exception(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}
	
	/**
	 * 
	 * @function:发送HTTP_POST请求  
	 * @param reqURL请求地址
	 * @param params
	 * @param encodeCharset
	 * @param decodeCharset
	 * @return String   
	 * @exception 
	 * @author:lilong   
	 * @since  1.0.0
	 */
	public static String sendPostRequest(String reqURL,
			Map<String, String> params, String encodeCharset,
			String decodeCharset)
	{
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost(reqURL);
		List<NameValuePair> formParams = new ArrayList<NameValuePair>(); // 创建参数队列
		for (Map.Entry<String, String> entry : params.entrySet())
		{
			Object value = entry.getValue();
			if(!(value instanceof String)){
				formParams.add(new BasicNameValuePair(entry.getKey(), String.valueOf(value)));
			}
			else{
				formParams.add(new BasicNameValuePair(entry.getKey(), (String)value));
			}
		}
		try
		{
			httpPost.setEntity(new UrlEncodedFormEntity(formParams,
					encodeCharset == null ? "UTF-8" : encodeCharset));
			
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (null != entity)
			{
				responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		}
		catch (Exception e)
		{
			log.error("与[" + reqURL + "]通信过程中发生异常,堆栈信息如下", e);
		}
		finally
		{
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}
	
	
	/**
	 * 
	 * @function: 发送HTTPS_POST请求 
	 * @param reqURL
	 * @param params
	 * @return String   
	 * @throws Exception 
	 * @exception 
	 * @author:lilong   
	 * @since  1.0.0
	 */
	public static String httpsPost(String reqURL,
			Map<String, String> params) throws Exception
	{
		return httpsPost(reqURL, params, null, null);
	}
	
	
	/**
	 * 
	 * @function:发送HTTPS_POST请求  
	 * @param reqURL请求地址
	 * @param params请求参数
	 * @param encodeCharset 编码字符集,编码请求数据时用之,其为null时默认采用UTF-8解码
	 * @param decodeCharset 解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
	 * @return String   远程主机响应正文
	 * @throws Exception 
	 * @exception 
	 * @author:lilong   
	 * @since  1.0.0
	 */
	public static String httpsPost(String reqURL, Map<String, String> params,
			String encodeCharset, String decodeCharset) throws Exception
	{
		String responseContent = "";
		HttpClient httpClient = new DefaultHttpClient();
		X509TrustManager xtm = new X509TrustManager()
		{
			
			public void checkClientTrusted(X509Certificate[] chain,
					String authType)
				throws CertificateException
			{
			}
			
			public void checkServerTrusted(X509Certificate[] chain,
					String authType)
				throws CertificateException
			{
			}
			
			public X509Certificate[] getAcceptedIssuers()
			{
				return null;
			}
		};
		try
		{
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, new TrustManager[] { xtm }, null);
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
			socketFactory
					.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			httpClient.getConnectionManager().getSchemeRegistry()
					.register(new Scheme("https", 443, socketFactory));
			
			HttpPost httpPost = new HttpPost(reqURL);
			List<NameValuePair> formParams = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entry : params.entrySet())
			{
				formParams.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(formParams,
					encodeCharset == null ? "UTF-8" : encodeCharset));
			
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (null != entity)
			{
				responseContent = EntityUtils.toString(entity,
						decodeCharset == null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		}
		catch (Exception e)
		{
			log.error("与[" + reqURL + "]通信过程中发生异常,堆栈信息为", e);
			throw e;
		}
		finally
		{
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}
	
	
	/**
	 * 
	 * @function:发送HTTP_POST请求 ,本方法默认的连接超时时间为30秒,默认的读取超时时间为30秒 
	 * @param reqURL 请求地址
	 * @param params 发送到远程主机的正文数据
	 * @return String 远程主机响应正文`HTTP状态码  
	 * @exception 
	 * @author:lilong   
	 * @since  1.0.0
	 */
	public static String sendPostRequestByJava(String reqURL,
			Map<String, String> params)
	{
		StringBuilder sendData = new StringBuilder();
		for (Map.Entry<String, String> entry : params.entrySet())
		{
			sendData.append(entry.getKey()).append("=")
					.append(entry.getValue()).append("&");
		}
		if (sendData.length() > 0)
		{
			sendData.setLength(sendData.length() - 1); // 删除最后一个&符号
		}
		return sendPostRequestByJava(reqURL, sendData.toString());
	}
	
	/**
	 * 发送HTTP_POST请求
	 * 
	 * @see 若发送的<code>sendData</code>中含有中文,记得按照双方约定的字符集将中文
	 *      <code>URLEncoder.encode(string,encodeCharset)</code>
	 * @see 本方法默认的连接超时时间为30秒,默认的读取超时时间为30秒
	 * @param reqURL 请求地址
	 * @param sendData 发送到远程主机的正文数据
	 * @return 远程主机响应正文`HTTP状态码,如<code>"SUCCESS`200"</code><br>
	 *         若通信过程中发生异常则返回"Failed`HTTP状态码",如<code>"Failed`500"</code>
	 */
	public static String sendPostRequestByJava(String reqURL, String sendData)
	{
		HttpURLConnection httpURLConnection = null;
		OutputStream out = null; // 写
		InputStream in = null; // 读
		int httpStatusCode = 0; // 远程主机响应的HTTP状态码
		try
		{
			URL sendUrl = new URL(reqURL);
			httpURLConnection = (HttpURLConnection) sendUrl.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true); // 指示应用程序要将数据写入URL连接,其值默认为false
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(30000); // 30秒连接超时
			httpURLConnection.setReadTimeout(30000); // 30秒读取超时
			
			out = httpURLConnection.getOutputStream();
			out.write(sendData.toString().getBytes());
			
			// 清空缓冲区,发送数据
			out.flush();
			
			// 获取HTTP状态码
			httpStatusCode = httpURLConnection.getResponseCode();
			
			// 该方法只能获取到[HTTP/1.0 200 OK]中的[OK]
			// 若对方响应的正文放在了返回报文的最后一行,则该方法获取不到正文,而只能获取到[OK],稍显遗憾
			// respData = httpURLConnection.getResponseMessage();
			
			// //处理返回结果
			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(httpURLConnection.getInputStream()));
			// String row = null;
			// String respData = "";
			// if((row=br.readLine()) != null){
			// //readLine()方法在读到换行[\n]或回车[\r]时,即认为该行已终止
			// respData = row; //HTTP协议POST方式的最后一行数据为正文数据
			// }
			// br.close();
			
			in = httpURLConnection.getInputStream();
			byte[] byteDatas = new byte[in.available()];
			in.read(byteDatas);
			return new String(byteDatas) + "`" + httpStatusCode;
		}
		catch (Exception e)
		{
			log.error(e.getMessage());
			return "Failed`" + httpStatusCode;
		}
		finally
		{
			if (out != null)
			{
				try
				{
					out.close();
				}
				catch (Exception e)
				{
					log.error("关闭输出流时发生异常,堆栈信息如下", e);
				}
			}
			if (in != null)
			{
				try
				{
					in.close();
				}
				catch (Exception e)
				{
					log.error("关闭输入流时发生异常,堆栈信息如下", e);
				}
			}
			if (httpURLConnection != null)
			{
				httpURLConnection.disconnect();
				httpURLConnection = null;
			}
		}
	}
	
	/**
	 * 忽视证书HostName
	 */
	private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier()
	{
		
		public boolean verify(String s, SSLSession sslsession)
		{
			System.out.println("WARNING: Hostname is not matched for cert.");
			return true;
		}
	};
	
	/**
	 * Ignore Certification
	 */
	private static TrustManager ignoreCertificationTrustManger = new X509TrustManager()
	{
		
		private X509Certificate[] certificates;
		
		@Override
		public void checkClientTrusted(X509Certificate certificates[],
				String authType)
			throws CertificateException
		{
			if (this.certificates == null)
			{
				this.certificates = certificates;
				System.out.println("init at checkClientTrusted");
			}
			
		}
		
		@Override
		public void checkServerTrusted(X509Certificate[] ax509certificate,
				String s)
			throws CertificateException
		{
			if (this.certificates == null)
			{
				this.certificates = ax509certificate;
				System.out.println("init at checkServerTrusted");
			}
			
		}
		
		@Override
		public X509Certificate[] getAcceptedIssuers()
		{
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
	public static String httpsGet(String urlString)
	{
		
		ByteArrayOutputStream buffer = new ByteArrayOutputStream(512);
		try
		{
			
			URL url = new URL(urlString);
			
			/*
			 * use ignore host name verifier
			 */
			HttpsURLConnection
					.setDefaultHostnameVerifier(ignoreHostnameVerifier);
			HttpsURLConnection connection = (HttpsURLConnection) url
					.openConnection();
			
			// Prepare SSL Context
			TrustManager[] tm = { ignoreCertificationTrustManger };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			javax.net.ssl.SSLSocketFactory ssf = sslContext.getSocketFactory();
			connection.setSSLSocketFactory(ssf);
			
			InputStream reader = connection.getInputStream();
			byte[] bytes = new byte[512];
			int length = reader.read(bytes);
			
			do
			{
				buffer.write(bytes, 0, length);
				length = reader.read(bytes);
			}
			while (length > 0);
			
			// result.setResponseData(bytes);
			System.out.println(buffer.toString());
			reader.close();
			
			connection.disconnect();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
		}
		String repString = new String(buffer.toByteArray());
		return repString;
	}
	
}