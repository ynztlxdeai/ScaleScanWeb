package com.moyansz.common;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

/**
 * 
 * @description: 字符串工具类
 * @fileName:StringUtils.java
 * @createTime:2015年3月18日 下午2:26:09
 * @author:肖震
 * @version 1.0.0
 * 
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{

	/**
	 * �?��字符串是否为空白 empty ("") or null 建议使用
	 * org.apache.commons.lang3.StringUtils.isBlank()
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().equals("");
	}
	
	public static boolean isEmpty(String ... values) {
		for(String value : values){
			if(isEmpty(value)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否手机号码 是=true
	 * @param value
	 * @return
	 */
	public static boolean isMobile(String value) {   
        Pattern p = Pattern.compile("^[0-9]{1,20}$");
        Matcher m = p.matcher(value);  
        return m.find();  
    }
	
	/**
	 * 是否包含特殊字符   包含=true
	 * @param value
	 * @return
	 */
	public static boolean specialChar(String value) {
		String regEx = "[;|<>`&!*(~^)#?:\"/$=\\'+]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(value);
        return m.find();  
    }
	
	/**
	 * 
	 * @function:去掉�?��空格
	 * @param str
	 * @return String
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static String trimAllEmpty(String str) {
		return str == null ? str : str.replaceAll(" +", "");
	}

	/**
	 * @function: 生成18位流水号，格式如�?0141215223209678776
	 * @return String
	 * @exception @author:Wuwenyong
	 * @since 1.0.0
	 */
	public static String getBusinessNum() {
		Date date = new Date();
		String sn = DateUtil.dateToString(date, "yyyyMMdd");
		String cur = DateUtil.dateToString(date, "yyyyMMddHHmmss");
		String sn_business_num1 = System.getProperty("sn_business_num");
		if (sn_business_num1 == null || "".equals(sn_business_num1)) {
			System.setProperty("sn_business_num", sn);// 设置已标识时间串
			System.setProperty("business_num_key", "1");// 设置自增长标识，�?�?��
			return cur + "0001";
		} else {
			int startNum = 1;// 尾部流水�?�?��
			String sn_business_num = sn;// 当天标识
			String key = "";
			if (sn_business_num.equals(System.getProperty("sn_business_num"))) {
				key = System.getProperty("business_num_key");
				if (key != null && !"".equals(key)) {
					startNum = Integer.parseInt(key);
					startNum++;
				}
			}

			String endNum = "" + startNum;
			if (endNum.length() == 1)// 自动标识长度�?
			{
				key = "000" + startNum;
			} else if (endNum.length() == 2)// 自动标识长度�?
			{
				key = "00" + startNum;
			} else if (endNum.length() == 3)// 自动标识长度�?
			{
				key = "0" + startNum;
			}
			System.setProperty("sn_business_num", sn);
			System.setProperty("business_num_key", "" + startNum);
			return cur + key;
		}
	}

	/**
	 * @function: 随机8位数字邀请码
	 * @return int
	 * @exception @author:Wuwenyong
	 * @since 1.0.0
	 */
	public static int inviteCode() {
		int code = 0;
		int number = 100000000;
		while (true) {
			code = (int) (Math.random() * number);
			if (String.valueOf(code).length() == 8 && code > 10000000 && code < 99999999) {
				break;
			}
		}
		return code;
	}
	
	/**
	 * @function: 随机6位数字邀请码
	 * @return int
	 * @exception @author:Wuwenyong
	 * @since 1.0.0
	 */
	public static int inviteCodeSix() {
		int code = 0;
		int number = 1000000;
		while (true) {
			code = (int) (Math.random() * number);
			if (String.valueOf(code).length() == 6 && code > 100000 && code < 999999) {
				break;
			}
		}
		return code;
	}
	/**
	 * 随机4位数字 短信验证码
	 * @return
	 */
	public static int inviteCodeFour() {
		int code = 0;
		int number = 10000;
		while (true) {
			code = (int) (Math.random() * number);
			if (String.valueOf(code).length() == 4 && code > 1000 && code < 9999) {
				break;
			}
		}
		return code;
	}

	/**
	 * 
	 * @function: 将空字符串转为null
	 * @param str
	 *            空字符串
	 * @return
	 * @return type Object
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static Object covertEmptyStringToNull(String str) {
		if (str != null && "".equals(str.trim())) {
			return null;
		} else {
			return str;
		}
	}

	/**
	 * 
	 * @function: 将null转为空字符串
	 * @param str
	 * @return
	 * @return type Object
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static String covertNullToEmptyString(String str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}

	public static Object covertNullObjectToEmptyString(Object str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}

	// 金额保存两位小数，并且不四舍五入
	public static BigDecimal moneyToKeepDecimals(Object object, int len) {
		String newMoney = "0.00";
		if (null != object) {
			String money = object.toString();
			if (money.contains(".")) {
				String[] strArray = money.split("\\.");
				if (1 == strArray[1].length()) {
					newMoney = money + "0";
				} else if (2 == strArray[1].length()) {
					newMoney = money;
				} else {
					newMoney = strArray[0] + "." + strArray[1].substring(0, len);
				}
			} else {
				newMoney = money + ".00";
			}
		}
		return new BigDecimal(newMoney);
	}

	public static String formatNumber(Double num) {
		try {
			return new DecimalFormat("##.##").format(num);
		} catch (Exception e) {
			return null;
		}
	}

	public static String formatTime(Date date) {
		if (date != null)
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return null;
	}

	public static String formatTime(String format, Date date) {
		if (date != null)
			return new SimpleDateFormat(format).format(date);
		return null;
	}

	/**
	 * 
	 * @function: 生成 interestIntoParmStr 参数收益转入接口参数
	 * @param param
	 * @return String
	 * @exception @author:叶威龙
	 * @since 1.0.0
	 */
	public static String buildInterestIntoParmStr(Map<String, Map<String, String>> param) {
		Set<String> keys = param.keySet();
		StringBuffer res = new StringBuffer();
		for (String k : keys) {
			Map<String, String> map = param.get(k);
			res.append(map.get("uid") + ",");
			res.append(map.get("hxAccName") + ",");
			res.append(map.get("loginPwd") + ",");
			res.append(map.get("amount") + ",");
			res.append(map.get("orderNo") + ",");
			res.append(map.get("datetime") + ",");
			res.append(map.get("remarkInfo") + ";");
		}
		return res.toString().substring(0, res.length() - 1);
	}

	/**
	 * 
	 * @function: 把Double格式化保留两位小数，但不四舍五入
	 * @param d
	 * @return String
	 * @exception @author:Zhanglinxing
	 * @since 1.0.0
	 */
	public static String formatDouble(Double d) {
		if (d != null) {
			DecimalFormat formater = new DecimalFormat();
			formater.setMaximumFractionDigits(2);
			formater.setGroupingSize(0);
			formater.setRoundingMode(RoundingMode.FLOOR);
			return formater.format(d);
		} else {
			return null;
		}
	}

	/**
	 * 过滤HTML标签
	 * 
	 * @function:
	 * @param str
	 * @return String
	 * @exception @author:李辞辞
	 * @since 1.0.0
	 */
	public static String toHTMLStr(String str) {
		String value = "";
		if (str == null)
			return null;
		value = str.replaceAll("&", "&amp;");
		value = value.replaceAll(">", "&gt;");
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll("\"", "&quot;");
		value = value.replaceAll("\'", "&#x27;");
		value = value.replaceAll("/", "&#x2F;");
		return value;
	}

	/**
	 * 把数字精确到小数点后两位，并且以千元分隔符分隔
	 * 
	 * @function:
	 * @param str
	 * @return String
	 * @exception @author:李辞辞
	 * @since 1.0.0
	 */
	public static String strToThousandSign(String str) {
		String newStr = "";
		DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
		try {
			double d = Double.parseDouble(str);
			newStr = df.format(d);
		} catch (IllegalArgumentException e) {
			newStr = null;
		}
		return newStr;
	}

	/**
	 * 删除指定内容的字符串方法
	 * 
	 * @function:
	 * @param 文本
	 * @param 需要去除的内容([^0-9])
	 * @return String
	 * @exception @author:qiuhai
	 * @since 1.0.0
	 */
	public static String removeString(String str, String param) {

		Pattern pattern = Pattern.compile(param);
		Matcher matcher = pattern.matcher(str);
		String result = matcher.replaceAll("");
		return result;
	}

	/**
	 * 根据特点字符来分割字符串 str： 要分割的字符串 type：分隔符 t：每隔t数量来分割字符串str 如str： 1324545334
	 * stype：， t：3 结果为：1,324,545,334
	 * 
	 * @exception @author:Zhanglinxing
	 * @since 1.0.0
	 */
	public static String getStringByType(String str, String type, int t) {
		String result = ""; // 要返回的字符串结果
		if (str.length() <= t) {
			return str;
		} else {
			str = new StringBuilder(str).reverse().toString(); // 先将字符串颠倒顺序
			for (int i = 0; i < str.length(); i++) {
				if (i * t + t > str.length()) {
					result += str.substring(i * t, str.length());
					break;
				}
				result += str.substring(i * t, i * t + t) + type;
			}
			if (result.endsWith(type)) {
				result = result.substring(0, result.length() - 1);
			}
		}
		return new StringBuilder(result).reverse().toString();
	}

	/*
	 * 银行卡号格式化bankNo:银行卡 ；frontNum:取前多少位；backNum:取后多少位
	 */
	public static String formatBankNo(String bankNo, int frontNum, int backNum) {
		if (StringUtils.isEmpty(bankNo)) {
			return "";
		}
		char[] s = bankNo.toCharArray();
		String newStr = "";
		for (int i = 0; i < s.length; i++) {
			if (i < frontNum) {// 取前多少位
				newStr += s[i];
			} else if ((backNum + 1) < i && i < s.length - backNum) {// 取后多少位
				newStr += "*";
			} else {
				newStr += s[i];
			}
			if ((i + 1) % 4 == 0) {
				newStr += " ";
			}
		}
		return newStr;
	}

	/**
	 * @function: 去掉字符串中的回车，换行等空白字符
	 * @param str
	 * @return String
	 * @exception @author:张进飞
	 * @since 1.0.0
	 */
	public static String replaceBlank(String str) {
		String dest = new String();
		if (null != str) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
	/**
	 * 一次性判断多个或单个对象为空。
	 * @param objects
	 * @author zhou-baicheng
	 * @return 只要有一个元素为Blank，则返回true
	 */
	public static boolean isBlank(Object...objects){
		Boolean result = false ;
		for (Object object : objects) {
			if(null == object || "".equals(object.toString().trim()) 
					|| "null".equals(object.toString().trim())){
				result = true ; 
				break ; 
			}
		}
		return result ; 
	}
	
	public static String getRandom(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val.toLowerCase();
	}
	/**
	 * 一次性判断多个或单个对象不为空。
	 * @param objects
     * @author zhou-baicheng
	 * @return 只要有一个元素不为Blank，则返回true
	 */
	public static boolean isNotBlank(Object...objects){
		return !isBlank(objects);
	}
	public static boolean isBlank(String...objects){
		Object[] object = objects ;
		return isBlank(object);
	}
	public static boolean isNotBlank(String...objects){
		Object[] object = objects ;
		return !isBlank(object);
	}
	public static boolean isBlank(String str){
		Object object = str ;
		return isBlank(object);
	}
	public static boolean isNotBlank(String str){
		Object object = str ;
		return !isBlank(object);
	}
	/**
	 * 判断一个字符串在数组中存在几个
	 * @param baseStr
	 * @param strings
	 * @return
	 */
	public static int indexOf(String baseStr,String[] strings){
		
		if(null == baseStr || baseStr.length() == 0 || null == strings)
			return 0;
		
		int i = 0;
		for (String string : strings) {
			boolean result = baseStr.equals(string);
			i = result ? ++i : i;
		}
		return i ;
	}
	/**
	 * 判断一个字符串是否为JSONObject,是返回JSONObject,不是返回null
	 * @param args
	 * @return
	 */
	public static net.sf.json.JSONObject isJSONObject(String args) {
		net.sf.json.JSONObject result = null ;
		if(isBlank(args)){
			return result ;
		}
		try {
			return net.sf.json.JSONObject.fromObject(args.trim());
		} catch (Exception e) {
			return result ;
		}
	}
	/**
	 * 判断一个字符串是否为JSONArray,是返回JSONArray,不是返回null
	 * @param args
	 * @return
	 */
	public static net.sf.json.JSONArray isJSONArray(Object args) {
		JSONArray result = new JSONArray();
		if(isBlank(args)){
			return null ;
		}
		if(args instanceof  net.sf.json.JSONArray){
			
			net.sf.json.JSONArray arr = (net.sf.json.JSONArray)args;
			for (Object json : arr) {
				if(json != null && json instanceof net.sf.json.JSONObject){
					result.add(json);
					continue;
				}else{
					result.add(JSONObject.fromObject(json));
				}
			}
			return result;
		}else{
			return null ;
		}
		
	}
	public static String trimToEmpty(Object str){
	  return (isBlank(str) ? "" : str.toString().trim());
	}
	
	/**
	 * 将 Strig  进行 BASE64 编码
	 * @param str [要编码的字符串]
	 * @param bf  [true|false,true:去掉结尾补充的'=',false:不做处理]
	 * @return
	 */
    public static String getBASE64(String str,boolean...bf) { 
       if (StringUtils.isBlank(str)) return null; 
       String base64 = new sun.misc.BASE64Encoder().encode(str.getBytes()) ;
       //去掉 '='
       if(isBlank(bf) && bf[0]){
    	   base64 = base64.replaceAll("=", "");
       }
       return base64;
    }

    /** 将 BASE64 编码的字符串 s 进行解码**/
    public static String getStrByBASE64(String s) { 
       if (isBlank(s)) return ""; 
       BASE64Decoder decoder = new BASE64Decoder(); 
       try { 
          byte[] b = decoder.decodeBuffer(s); 
          return new String(b); 
       } catch (Exception e) { 
          return ""; 
       }
    }
    /**
     * 把Map转换成get请求参数类型,如 {"name"=20,"age"=30} 转换后变成 name=20&age=30
     * @param map
     * @return
     */
    public static String mapToGet(Map<? extends Object,? extends Object> map){
    	String result = "" ;
    	if(map == null || map.size() ==0){
    		return result ;
    	}
    	Set<? extends Object> keys = map.keySet();
    	for (Object key : keys ) {
    		result += ((String)key + "=" + (String)map.get(key) + "&");
		}
    	
    	return isBlank(result) ? result : result.substring(0,result.length() - 1);
    }
    /**
     * 把一串参数字符串,转换成Map 如"?a=3&b=4" 转换为Map{a=3,b=4}
     * @param args
     * @return
     */
    public static Map<String, ? extends Object> getToMap(String args){
    	if(isBlank(args)){
    		return null ;
    	}
    	args = args.trim();
    	//如果是?开头,把?去掉
    	if(args.startsWith("?")){
    		args = args.substring(1,args.length());
    	}
    	String[] argsArray = args.split("&");
    	
    	Map<String,Object> result = new HashMap<String,Object>();
    	for (String ag : argsArray) {
			if(!isBlank(ag) && ag.indexOf("=")>0){
				
				String[] keyValue = ag.split("=");
				//如果value或者key值里包含 "="号,以第一个"="号为主 ,如  name=0=3  转换后,{"name":"0=3"}, 如果不满足需求,请勿修改,自行解决.
					
				String key = keyValue[0];
				String value = "" ;
				for (int i = 1; i < keyValue.length; i++) {
					value += keyValue[i]  + "=";
				}
				value = value.length() > 0 ? value.substring(0,value.length()-1) : value ;
				result.put(key,value);
				
			}
		}
    	
    	return result ;
    }
    
    /**
	 * 转换成Unicode
	 * @param str
	 * @return
	 */
    public static String toUnicode(String str) {
        String as[] = new String[str.length()];
        String s1 = "";
        for (int i = 0; i < str.length(); i++) {
        	int v = str.charAt(i);
        	if(v >=19968 && v <= 171941){
	            as[i] = Integer.toHexString(str.charAt(i) & 0xffff);
	            s1 = s1 + "\\u" + as[i];
        	}else{
        		 s1 = s1 + str.charAt(i);
        	}
        }
        return s1;
     }
    /**
     * 合并数据
     * @param v
     * @return
     */
    public static String merge(Object...v){
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i < v.length; i++) {
    		sb.append(v[i]);
		}
    	return sb.toString() ; 
    }
    /**
     * 字符串转urlcode
     * @param value
     * @return
     */
    public static String strToUrlcode(String value){
    	try {
			value = java.net.URLEncoder.encode(value,"utf-8");
			return value ;
		} catch (UnsupportedEncodingException e) {
			LoggerUtils.error(StringUtils.class, "字符串转换为URLCode失败,value:" + value,e);
			e.printStackTrace();
			return null;
		}    
    }
    /**
     * urlcode转字符串
     * @param value
     * @return
     */
    public static String urlcodeToStr(String value){
    	try {
			value = java.net.URLDecoder.decode(value,"utf-8");
			return value ;
		} catch (UnsupportedEncodingException e) {
			LoggerUtils.error(StringUtils.class, "URLCode转换为字符串失败;value:" + value,e);
			e.printStackTrace();
			return null;
		}  
    }
    /**
     * 判断字符串是否包含汉字
     * @param txt
     * @return
     */
    public static Boolean containsCN(String txt){
    	if(isBlank(txt)){
    		return false;
    	}
    	for (int i = 0; i < txt.length(); i++) { 

    		String bb = txt.substring(i, i + 1); 

    		boolean cc = java.util.regex.Pattern.matches("[\u4E00-\u9FA5]", bb);
    		if(cc)
    		return cc ;
    	}
		return false;
    }
    /**
     * 去掉HTML代码
     * @param news
     * @return
     */
    public static String removeHtml(String news) {
      String s = news.replaceAll("amp;", "").replaceAll("<","<").replaceAll(">", ">");
      
      Pattern pattern = Pattern.compile("<(span)?\\sstyle.*?style>|(span)?\\sstyle=.*?>", Pattern.DOTALL);
      Matcher matcher = pattern.matcher(s);
      String str = matcher.replaceAll("");
      
      Pattern pattern2 = Pattern.compile("(<[^>]+>)",Pattern.DOTALL);
      Matcher matcher2 = pattern2.matcher(str);
      String strhttp = matcher2.replaceAll(" ");
      
      
      String regEx = "(((http|https|ftp)(\\s)*((\\:)|：))(\\s)*(//|//)(\\s)*)?"
         + "([\\sa-zA-Z0-9(\\.|．)(\\s)*\\-]+((\\:)|(:)[\\sa-zA-Z0-9(\\.|．)&%\\$\\-]+)*@(\\s)*)?"
         + "("
         + "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])"
         + "(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)"
         + "(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)"
         + "(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])"
         + "|([\\sa-zA-Z0-9\\-]+(\\.|．)(\\s)*)*[\\sa-zA-Z0-9\\-]+(\\.|．)(\\s)*[\\sa-zA-Z]*"
         + ")"
         + "((\\s)*(\\:)|(：)(\\s)*[0-9]+)?"
         + "(/(\\s)*[^/][\\sa-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$\\=~_\\-@]*)*";
      Pattern p1 = Pattern.compile(regEx,Pattern.DOTALL);
      Matcher matchhttp = p1.matcher(strhttp);
      String strnew = matchhttp.replaceAll("").replaceAll("(if[\\s]*\\(|else|elseif[\\s]*\\().*?;", " ");
      
      
      Pattern patterncomma = Pattern.compile("(&[^;]+;)",Pattern.DOTALL);
      Matcher matchercomma = patterncomma.matcher(strnew);
      String strout = matchercomma.replaceAll(" ");
      String answer = strout.replaceAll("[\\pP‘’“”]", " ")
        .replaceAll("\r", " ").replaceAll("\n", " ")
        .replaceAll("\\s", " ").replaceAll("　", "");

      
      return answer;
    }
    /**
	 * 把数组的空数据去掉
	 * @param array
	 * @return
	 */
	public static List<String> array2Empty(String[] array){
		List<String> list = new ArrayList<String>();
		for (String string : array) {
			if(StringUtils.isNotBlank(string)){
				list.add(string);
			}
		}
		return list;
	}
	/**
	 * 把数组转换成set
	 * @param array
	 * @return
	 */
	public static Set<?> array2Set(Object[] array) {
		Set<Object> set = new TreeSet<Object>();
		for (Object id : array) {
			if(null != id){
				set.add(id);
			}
		}
		return set;
	}
	
	/**
	 * 得到String的CRC32值
	 * @param str
	 * @return
	 * @日期 2016年8月15日
	 * @author lilong
	 */
	public static long getCRC32(String str){
		CRC32 crc32 = new CRC32();
		crc32.update(str.getBytes());
		
		long crcValue = crc32.getValue();
		int crcLength = String.valueOf(crcValue).length();
		
		// 补全10位数字
		if(crcLength < 10){
			for(int i=10; i > crcLength; i--){
				crcValue = crcValue*10;
			}
		}
		return crcValue;
	}
	
	/**
	 * 生成随机数字串
	 * @param lenth
	 * @return
	 * @日期 2016年10月18日
	 * @author lilong
	 */
	public static String randomNumber(int lenth) {
		StringBuffer result = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < lenth; i++) {
			result.append(random.nextInt(10));
		}
		return result.toString();
	}
   
	
	public static boolean isValidDate(String sDate) {
	     String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
	     String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
	             + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
	             + "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
	             + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
	             + "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
	             + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
	     if ((sDate != null)) {
	         Pattern pattern = Pattern.compile(datePattern1);
	         Matcher match = pattern.matcher(sDate);
	         if (match.matches()) {
	             pattern = Pattern.compile(datePattern2);
	             match = pattern.matcher(sDate);
	             return match.matches();
	         }
	         else {
	             return false;
	         }
	     }
	     return false;
	}

	public static boolean isValidDate2(String sDate){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			format.parse(sDate);
			return true;
		} catch (ParseException e) {
			return false;
		}		
	}
	
	public static void main(String[] args) {
//		System.out.println(toHTMLStr("<script>alert(1);</script>"));
//		System.out.println(strToThousandSign("456789.12322"));
//		System.out.println(isValidDate("2016-01-30"));
//		System.out.println(getCRC32("6a102e3287694610b3263d7ecf7e1f59"));
//		System.out.println(getCRC32("022f25cb40df40bd8a7629cdcae7a79d"));
//		System.out.println(getCRC32("8f60344c9b5045849843b4a235832ffb"));
		
		System.out.println(isMobile("122222222233333333333"));

	}
}
