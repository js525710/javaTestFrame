package com.testing.test2;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;


public class HttpclientKw {
	//是否使用cookie标志位，默认不使用
	private boolean useCookie = false;
	//cookieStore类，httpclient用它来记录得到的cookie值
	public CookieStore cookies = new BasicCookieStore();
    //成员变量headers，用于存放需要加载的头域参数
	private Map<String, String> headers = new HashMap<String, String>();
	//是否添加header，默认不添加
	private boolean addHeaderFlag = false;
	//httpclient对象客户端发包
    private CloseableHttpClient client;
    //匹配Unicode编码格式的正则表达式
    private static final Pattern reUnicode = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
    
    
    /**
     * 查找字符串中的Unicode编码并转换为中文
     * @param u
     * @return
     */
    private String DeCode(String u) {
    	try {
			Matcher m = reUnicode.matcher(u);
			//创建一个 长度和原始参数相等的Stringbuffer
			StringBuffer sb = new StringBuffer(u.length());
			while (m.find()) {
				//通过十六进制的数强制转化成为char型，得到Unicode编码对应的字符，再将其转换为string，替换原有的Unicode编码。并添加至sb中
				m.appendReplacement(sb, Character.toString((char) Integer.parseInt(m.group(1),16)));
			}
			m.appendTail(sb);
			return sb.toString();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return u;
		}
    	
    }

    /**
     * SSLcontext用于绕过ssl验证，使发包的方法能够对https的接口进行请求
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
    	SSLContext sc = SSLContext.getInstance("SSLv3");
    	//实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
    	X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		sc.init(null, new TrustManager[] { trustManager}, null);
		return sc;
    	
    }
	
	/**
	 * 通过httpclient实现get 方法，其中包括代理地址的设置、头域添加和cookie使用
	 */
	public String doGet(String url,String param) throws Exception {
		//存储返回实体的string内容
		String body ="";
		//采用绕过验证的方式处理https请求
		SSLContext sslcontent=createIgnoreVerifySSL();
		//设置协议http和https对应的处理socket链接工厂的对象
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().
				register("http", PlainConnectionSocketFactory.INSTANCE).
				register("https", new SSLConnectionSocketFactory(sslcontent)).build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		//当设置代理抓包时，启动如下代码，否则，用下一段代码
		//设置代理地址，适用于需要fiddler抓包时使用，不用时候切记注释掉这句
//		HttpHost proxy = new HttpHost("localhost", 8888, "http");  
//		//基于是否需要使用cookie，用不同方式创建httpclient实例，决定是否添加cookiestore设置
//		if (useCookie) {
//			client = HttpClients.custom().setProxy(proxy).setConnectionManager(connManager).setDefaultCookieStore(cookies).build();
//		} else {
//			client = HttpClients.custom().setProxy(proxy).setConnectionManager(connManager).build();
//		}
		
		//不使用代理抓包时，用该段代码
		//基于是否需要使用cookie，用不同方式创建httpclient实例，决定是否添加cookiestore设置
		if (useCookie) {
			//实例化httpclient时，使用cookieStore,此时将会使用cookie
			client = HttpClients.custom().setConnectionManager(connManager).setDefaultCookieStore(cookies).build();
		}else {
			client = HttpClients.custom().setConnectionManager(connManager).build();
		}
		
		try {
			//拼接url地址和参数列表
			String urlWithParam = "";
			if (param.length()>0) {
				urlWithParam=url+"?"+param;
			}else {
				urlWithParam = url;
			}
			//创建get方式请求对象
			HttpGet get = new HttpGet(urlWithParam);
			//设置连接的超时时间						 //指定收发包的超时时间
			RequestConfig config = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(10000).build();
			get.setConfig(config);
			
			//指定报文头Content-type、User-Agent
			get.setHeader("accept", "*/*");
			get.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");

			//通过是否添加头域的标识符判断是否执行头域参数添加操作
			if (addHeaderFlag=true) {
				//从头域map中遍历添加头域
				Set<String> headerKeys  = headers.keySet();
				for(String key:headerKeys) {
					get.setHeader(key, headers.get(key));
				}
			}
			
			//执行请求操作
			CloseableHttpResponse response = client.execute(get);
			//打印所有的cookie
			List<Cookie> cookiestore = cookies.getCookies();
			for(Cookie c:cookiestore) {
				System.out.println(c);
			}
			
			//获取结果实体
			HttpEntity entity = response.getEntity();
			if(entity != null) {
				
				//按指定编码转换结果实体为String类型
				body = EntityUtils.toString(entity, "UTF-8");
			}
			
			//关闭 流实体
			EntityUtils.consume(entity);
			//释放链接
			response.close();
			//Unicode编码的解码操作
			String result = DeCode(body);
			System.out.println("result:"+result);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			body = e.fillInStackTrace().toString();
			e.printStackTrace();
		}finally {
			client.close();
		}
		return null;
		
		
		
		
	}

	/**
	 * 通过httpclient方法实现post方法；其中包括代理地址的设置、头域添加和cookie使用
	 */
	public String doPost(String url, String param) throws Exception {
		//接收返回数据的String
		String body = "";

		// 采用绕过验证的方式处理https请求
		SSLContext sslcontext = createIgnoreVerifySSL();
		// 设置协议http和https对应的处理socket链接工厂的对象，用于同时发送http和https请求
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(sslcontext)).build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		
		//当需要进行代理抓包时，启动如下代码，否则，用下一段代码。
		//设置代理地址，适用于需要用fiddler抓包时使用，不用时切记注释掉这句！
//		HttpHost proxy = new HttpHost("localhost", 8888, "http");  
//		//基于是否需要使用cookie，用不同方式创建httpclient实例，决定是否添加cookiestore设置
//		if (useCookie) {
//			client = HttpClients.custom().setProxy(proxy).setConnectionManager(connManager).setDefaultCookieStore(cookies).build();
//		} else {
//			client = HttpClients.custom().setProxy(proxy).setConnectionManager(connManager).build();
//		}
	
		//不使用代理抓包时，用该段代码。
		//基于是否需要使用cookie，用不同方式创建httpclient实例，决定是否添加cookiestore设置
		if (useCookie) {
			//实例化httpclient时，使用cookieStore，此时将会使用cookie
			client = HttpClients.custom().setConnectionManager(connManager).setDefaultCookieStore(cookies).build();
		} else {
			//实例化httpclient时，使用cookieStore，此时将不使用cookie
			client = HttpClients.custom().setConnectionManager(connManager).build();
		}

		//拼接接口地址和参数
		try {
			String urlWithParam = "";
			StringBuilder stringBuilder = new StringBuilder(url);
			if (param.length() > 0) {
				
				Map<String,String> map = JSON.parseObject(param, new TypeReference<Map<String,String>>() {});
				if (url.contains("?")) {
				   System.out.println("url中不含？");
				}else {
					stringBuilder.append("?");
					System.out.println("使用？进行参数的拼接");
				}
				map.forEach((k,v)->{
					String encodeParam;
					try {
						encodeParam = URLEncoder.encode(v, "utf-8");
						stringBuilder.append(k+"="+ encodeParam);
						stringBuilder.append("&");

					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				});
				 String urlStringBuilder = stringBuilder.toString();
				urlWithParam = urlStringBuilder.substring(0, urlStringBuilder.length()-1);
			} else {
				urlWithParam = url;
			}
			
			// 创建post方式请求对象
			HttpPost httpPost = new HttpPost(urlWithParam);
			RequestConfig config=RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(10000).build();
			httpPost.setConfig(config);
			// 指定报文头Content-type、User-Agent
			httpPost.setHeader("accept", "*/*");
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");

			//通过是否添加头域的标识符判断是否执行头域参数添加操作
			if (addHeaderFlag = true) {
				//从头域map中遍历添加头域
				Set<String> headerKeys = headers.keySet();
				for (String key : headerKeys) {
					httpPost.setHeader(key, headers.get(key));
				}
			}
			
			// 执行请求操作，并拿到结果
			CloseableHttpResponse response = client.execute(httpPost);

			//打印所有cookie
			List<Cookie> cookiestore = cookies.getCookies();
			for (Cookie c : cookiestore) {
				System.out.println(c);
			}

			// 获取结果实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 按指定编码转换结果实体为String类型
				body = EntityUtils.toString(entity, "UTF-8");
			}

			EntityUtils.consume(entity);
			// 释放链接
			response.close();
			String result = DeCode(body);
			System.out.println("result:" + result);
			return result;
		} catch (Exception e) {
			System.out.println();
			body=e.fillInStackTrace().toString();
			e.printStackTrace();
		} finally {
			client.close();
		}
		return null;
	}

	
	/**
	*实现httpclient发送json格式请求的方法
	 */
	public String doPostJson(String url,String jsonparam) throws Exception {
		String body = "";
		//采用绕过验证的方式处理https请求
		SSLContext sslcontext = createIgnoreVerifySSL();
		// 设置协议http和https对应的处理socket链接工厂的对象
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(sslcontext)).build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		HttpClients.custom().setConnectionManager(connManager);
		
//		//当需要进行代理抓包时，启动如下代码，否则，用下一段代码。
//		//设置代理地址，适用于需要用fiddler抓包时使用，不用时切记注释掉这句！
//		HttpHost proxy = new HttpHost("localhost", 8888, "http");
//		//基于是否需要使用cookie，用不同方式创建httpclient实例，决定是否添加cookiestore设置
//		if (useCookie) {
//			client = HttpClients.custom().setProxy(proxy).setConnectionManager(connManager).setDefaultCookieStore(cookies).build();
//		} else {
//			client = HttpClients.custom().setProxy(proxy).setConnectionManager(connManager).build();
//		}
		
		//不使用代理抓包时,用该段代码
		//基于是否需要使用cookie，用不同方式创建httpclient实例 ，决定是否添加cookiestore设置
		if (useCookie) {
			//实例化httpclient时，使用cookieStore，此时将会使用cookie
			client = HttpClients.custom().setConnectionManager(connManager).setDefaultCookieStore(cookies).build();
		} else {
			//实例化httpclient时，使用cookieStore，此时将不使用cookie
			client = HttpClients.custom().setConnectionManager(connManager).build();
		}
		
		
		try {
			//创建post方式请求对象
			HttpPost httpPost = new HttpPost(url);
			//设置请求超时时限
			RequestConfig config = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(10000).build();
			httpPost.setConfig(config);
			// 指定报文头Content-type、User-Agent
			httpPost.setHeader("Accept", "*/*");
			httpPost.setHeader("Content-type", "application/json;charset=UTF-8");
			httpPost.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");

			//通过是否添加头域的标识符判断是否执行头域参数添加操作
			if (addHeaderFlag = true) {
				//从头域map中遍历添加头域
				Set<String> headerKeys = headers.keySet();
				for (String key : headerKeys) {
					httpPost.setHeader(key, headers.get(key));
				}
			}
			
			StringEntity jsonReq = new StringEntity(jsonparam);
			jsonReq.setContentEncoding("utf-8");
			jsonReq.setContentType("application/json;charset=utf-8");
			httpPost.setEntity(jsonReq);
			
			// 执行请求操作，并拿到结果
			CloseableHttpResponse response = client.execute(httpPost);

			// 获取结果实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 按指定编码转换结果实体为String类型
				body = EntityUtils.toString(entity,"UTF-8");
			}

			EntityUtils.consume(entity);
			// 释放链接
			response.close();
			String result = DeCode(body);
			System.out.println("body:" + body);
			System.out.println("result:" + result);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println();
			body = e.fillInStackTrace().toString();
			e.printStackTrace();
		}finally {
			client.close();
		}
		return null;	
	}
	
	public String doUpload(String url ,String filePath) throws Exception {
		String body = "";

		// 采用绕过验证的方式处理https请求
		SSLContext sslcontext = createIgnoreVerifySSL();
		// 设置协议http和https对应的处理socket链接工厂的对象，用于同时发送http和https请求
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(sslcontext)).build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		
		//创建httpclient对象
		CloseableHttpClient client;
		//设置代理地址，适用于需要用fiddler抓包时使用，不用时切记注释掉这句！
//		HttpHost proxy = new HttpHost("localhost", 8888, "http");  
		//当需要进行代理抓包时，启动如下代码，否则，用下一段代码。
//		if (useCookie) {
//			client = HttpClients.custom().setProxy(proxy).setConnectionManager(connManager).setDefaultCookieStore(cookies).build();
//		} else {
//			client = HttpClients.custom().setProxy(proxy).setConnectionManager(connManager).build();
//		}

		//基于是否需要使用cookie，用不同方式创建httpclient实例。
		if (useCookie) {
			//实例化httpclient时，使用cookieStore，此时将会使用cookie
			client = HttpClients.custom().setConnectionManager(connManager).setDefaultCookieStore(cookies).build();
		} else {
			//实例化httpclient时，使用cookieStore，此时将不使用cookie
			client = HttpClients.custom().setConnectionManager(connManager).build();
		}
		
		try {
		//基于url创建put方法
		HttpPost postFile= new HttpPost(url);
		RequestConfig config=RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(10000).build();
		postFile.setConfig(config);
		// 指定报文头Content-type、User-Agent
		postFile.setHeader("accept", "*/*");
		postFile.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
		File upFile=new File(filePath);
		MultipartEntityBuilder mtp=MultipartEntityBuilder.create();
		mtp.addBinaryBody("file", upFile);
		HttpEntity uploadEntity=mtp.build();
		postFile.setEntity(uploadEntity);
		// 执行请求操作，并拿到结果
		CloseableHttpResponse response = client.execute(postFile);

		// 获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			// 按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, "UTF-8");
		}

		EntityUtils.consume(entity);
		// 释放链接
		response.close();
		String result = DeCode(body);
		System.out.println("result:" + result);
		return result;
		}
		catch (Exception e) {
			System.out.println();
			body=e.fillInStackTrace().toString();
			e.printStackTrace();
		} finally {
			client.close();
		}
		return null;
		
	}
	
	public  void addHeader(Map<String, String> headerMap) {
		headers = headerMap;
		addHeaderFlag = true;
	}
	
	/**
	 * 使用cookies设置标志位为true
	 */
	public void saveCookie() {
		useCookie = true;
	}


	/**
	 * 设置cookie标志位为false 并初始化cookies
	 */
	public void clearCookie() {
		useCookie = false;
		cookies = new BasicCookieStore();
	}
	
	
	public void clearHeader() {
		addHeaderFlag = false;
		headers = new HashMap<String, String>();
	}
	


}
