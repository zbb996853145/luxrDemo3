package cn.itcast.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

//使用beanutils操纵bean的属性(第三方)
public class Demo1 {
	@Test
	public void test1() throws Exception{
		Person p=new Person();
		BeanUtils.setProperty(p, "age", 456);
		System.out.println(p.getAge());//456
	}
	@Test
	public void test2() throws Exception{
		String name="aaaa";
		String age="123";
		String password="pw";
				
		Person p=new Person();
		//只支持8中基本数据类型
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "password", password);
		
		System.out.println(p.getName());//aaaa
		System.out.println(p.getAge());//123
		System.out.println(p.getPassword());//pw

	}
	@Test
	public void test3() throws Exception{

		String birthday="1983-12-1";
		
		/**为了让日期赋值到bean的birthday属性上，给beanUtils注册一个日期转换器
		 * 遇到复杂类型,要注册类型转换器
		 */
		//ConvertUtils.register(converter, clazz);
		ConvertUtils.register(new Converter(){//Converter是接口
			
			public Object convert(Class type, Object value) {
				if(value==null) return null;
				//判断是否为String	//instanceof操作符主要用于向下造型。 如：动物有老虎  
				if(!(value instanceof String)){
					throw new ConversionException("只支持String类型转换");
				}
				String str=(String)value;
				if(str.trim().equals("")) return null;
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd",Locale.US);
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);//异常链不能断--e不能少					
				}
			}
		}, Date.class);
		Person p=new Person();
		BeanUtils.setProperty(p, "birthday", birthday);
		System.out.println(p.getBirthday());//pw\
//		Date date = p.getBirthday();
//		System.out.println(date.toString());
//		System.out.println(date.toLocaleString());
//		System.out.println("___"+BeanUtils.getProperty(p, "birthday"));
	}
	@Test
	public void test5() throws Exception {
		Map map=new HashMap();
		map.put("name", "aaa");
		map.put("password", "123");
		map.put("birthday", "1980-09-09");
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person p=new Person();
		//用map集合中的值,填充bean的属性
		BeanUtils.populate(p, map);
		System.out.println(p.getBirthday());
	}
}
