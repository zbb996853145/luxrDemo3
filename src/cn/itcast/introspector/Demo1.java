package cn.itcast.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import org.junit.Test;

//使用内省API操作bean的属性
public class Demo1 {
	
	//得到bean的所有属性
	@Test
	public void test1() throws IntrospectionException{
		BeanInfo info=Introspector.getBeanInfo(Person.class);//拿到BeanInfo,就拿到了bean的所有属性
		//info2是堕调从Object父类继承的属性
		BeanInfo info2=Introspector.getBeanInfo(Person.class,Object.class);//得到bean自己的属性
		
//		PropertyDescriptor[] pds=info.getPropertyDescriptors();//拿到属性描述器
		PropertyDescriptor[] pds=info2.getPropertyDescriptors();//拿到属性描述器
		for(PropertyDescriptor pd:pds){
			System.out.println(pd.getName());
			//ab age class name	password
		}
	}
	//操纵bean的指定属性	age
	@Test
	public void test2() throws  Exception{
		Person p=new Person();
		PropertyDescriptor pd=new PropertyDescriptor("age", Person.class);
		//得到属性的写方法,为属性赋值
		Method method=pd.getWriteMethod();//public void setAge(int age) {
		method.invoke(p, 45);
		System.out.println(p.getAge());//45
		
		//获取属性的值
		method=pd.getReadMethod();//public int getAge() {
		System.out.println(method.invoke(p, null));//45
	}
	//高级点的内容,获取当前操作的属性的类型
	@Test
	public void test3() throws  Exception{
		Person p=new Person();
		PropertyDescriptor pd=new PropertyDescriptor("age", Person.class);
			
		//得到属性传参的类型
		Method method=pd.getWriteMethod();
		System.out.println(pd.getPropertyType());//int
		method.invoke(p, 45);
		System.out.println(p.getAge());//45
		
		
		method=pd.getReadMethod();
		System.out.println(method.invoke(p, null));//45
	}
}
