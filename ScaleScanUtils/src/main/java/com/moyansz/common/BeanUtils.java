package com.moyansz.common;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;


/**
 * @description:一系列bean工具类
 * @fileName:BeanUtils.java
 * @createTime:2015年3月23日 下午6:55:18
 * @author: lilong
 * @version 1.0.0
 * 
 */
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {
	/**
	 * @function: 将实体转为map
	 * @param bean
	 * @return Map
	 * @exception @author:Wuwenyong
	 * @since 1.0.0
	 */
	public static Map bean2Map(Object bean) {
		try {
			Class type = bean.getClass();
			Map returnMap = new HashMap();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null && !"".equals(result.toString())) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, null);// 属性值为空值处理为null
					}
				}
			}
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap();
		}
	}

	/**
	 * @function: 将实体转为map
	 * @param bean
	 * @return Map
	 * @exception @author:Wuwenyong
	 * @since 1.0.0
	 */
	public static Map beanToMap(Object bean) {
		try {
			Class type = bean.getClass();
			Map returnMap = new HashMap();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, null);// 属性值为空值处理为null
					}
				}
			}
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap();
		}
	}

	/**
	 * @function: 把对象的属性值转换成list结果集
	 * @param obj
	 * @return List<Object>
	 * @exception @author:Wuwenyong
	 * @since 1.0.0
	 */
	public static List<Object> renderObjValue(Object obj) {
		List<Object> objData = new ArrayList<Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		if (fields == null || fields.length < 1)
			return null;
		try {
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();
				if ("serialVersionUID".equals(fieldName) || fieldName.contains("_ignore_"))// 忽略字段
					continue;
				StringBuffer getMethodName = new StringBuffer("get").append(fieldName.substring(0, 1).toUpperCase())
						.append(fieldName.substring(1, fieldName.length()));
				Method getMethod = obj.getClass().getMethod(getMethodName.toString());
				Object tarValue = getMethod.invoke(obj);
				objData.add(tarValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Object>();
		}
		return objData;
	}
	
	/**
	   * 将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性
	   * 
	   * @param dest
	   *            目标对象，标准的JavaBean
	   * @param orig
	   *            源对象，可为Map、标准的JavaBean
	   * @throws BusinessException
	   */
	  @SuppressWarnings("rawtypes")
	  public static void object2OtherObject(Object dest, Object orig) throws Exception {
	    try {
	      if (orig instanceof Map) {
	        Iterator names = ((Map) orig).keySet().iterator();
	        while (names.hasNext()) {
	          String name = (String) names.next();
	          if (PropertyUtils.isWriteable(dest, name)) {
	            Object value = ((Map) orig).get(name);
	            if (value != null) {
	              PropertyUtils.setSimpleProperty(dest, name, value);
	            }
	          }
	        }
	      } else {
	        java.lang.reflect.Field[] fields = orig.getClass().getDeclaredFields();
	        for (int i = 0; i < fields.length; i++) {
	          String name = fields[i].getName();
//	          if (PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)) {
//	            Object value = PropertyUtils.getSimpleProperty(orig, name);
	            Object value = PropertyUtils.getProperty(orig, name);
	            if (value != null) {
//	              PropertyUtils.setSimpleProperty(dest, name, value);
	              PropertyUtils.setProperty(dest, name, value);
	            }
//	          }
	        }
	      }
	    } catch (Exception e) {
	      throw new Exception("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", e);
	    }
	  }
	  
	  /**
	   * 将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性
	   * 
	   * @param dest
	   *            目标对象，标准的JavaBean
	   * @param orig
	   *            源对象，可为Map、标准的JavaBean
	   * @throws BusinessException
	   */
	  @SuppressWarnings("rawtypes")
	  public static void object2OtherObject(Object dest, Object orig,List<String> excludeField) throws Exception {
	    try {
	      if (orig instanceof Map) {
	        Iterator names = ((Map) orig).keySet().iterator();
	        while (names.hasNext()) {
	          String name = (String) names.next();
	          if (PropertyUtils.isWriteable(dest, name)) {
	            Object value = ((Map) orig).get(name);
	            if (value != null) {
	              PropertyUtils.setSimpleProperty(dest, name, value);
	            }
	          }
	        }
	      } else {
	        java.lang.reflect.Field[] fields = orig.getClass().getDeclaredFields();
	        for (int i = 0; i < fields.length; i++) {
	          String name = fields[i].getName();
//	          if (PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)) {
//	            Object value = PropertyUtils.getSimpleProperty(orig, name);
	            Object value = PropertyUtils.getProperty(orig, name);
	            if (value != null) {
	            	if(excludeField == null){//
//		  	              PropertyUtils.setSimpleProperty(dest, name, value);
		  	              PropertyUtils.setProperty(dest, name, value);
	            	}
	            	else{
	            		if(!excludeField.contains(name)){
//			  	              PropertyUtils.setSimpleProperty(dest, name, value);
			  	              PropertyUtils.setProperty(dest, name, value);
	            		}
	            	}

	            }
//	          }
	        }
	      }
	    } catch (Exception e) {
	      throw new Exception("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", e);
	    }
	  }

	  /**
	   * 将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性
	   * 
	   * @param orig
	   *            源对象，标准的JavaBean
	   * @param dest
	   *            排除检查的属性，Map
	   * 
	   * @throws BusinessException
	   */
	  @SuppressWarnings("rawtypes")
	  public static boolean object2OtherObject2(Object orig, Map dest) throws Exception {
	    try {
	      java.lang.reflect.Field[] fields = orig.getClass().getDeclaredFields();
	      for (int i = 0; i < fields.length; i++) {
	        String name = fields[i].getName();
	        if (!dest.containsKey(name)) {
	          if (PropertyUtils.isReadable(orig, name)) {
	            Object value = PropertyUtils.getSimpleProperty(orig, name);
	            if (value == null) {
	              return true;
	            }
	          }
	        }
	      }
	      return false;
	    } catch (Exception e) {
	      throw new Exception("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", e);
	    }
	  }
	  
	  
	public static Map<String, Object> transBean2Map(Object obj, String... kes) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					if (null != kes && kes.length > 0) {
						for (String newKey : kes) {
							if (newKey.equals(key)) {
								// 得到property对应的getter方法
								Method getter = property.getReadMethod();
								Object value = getter.invoke(obj);
								map.put(key, value);
							}
						}
					}else{
						Method getter = property.getReadMethod();
						Object value = getter.invoke(obj);
						map.put(key, value);
					}
				}

			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}
		return map;
	}
	
	public static void main(String[] args) {
		/*Account stu = new Account();
		stu.setAcc("aaa");
		stu.setAcmail(2);
		stu.setEmail("eeee");
		String[] kes ={"acc","aa","bb"};
		System.out.println(transBean2Map(stu,kes));*/
	}
}
