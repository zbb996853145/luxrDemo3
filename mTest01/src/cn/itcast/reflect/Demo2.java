package cn.itcast.reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//解剖类的构造函数,创建类的对象
public class Demo2 {

	//反射构造函数	public Person()
	@Test
	public void test1() throws Exception{
		
		Class clazz=Class.forName("cn.itcast.reflect.Person");//加载类//封装了类的字节码
		Constructor c=clazz.getConstructor(null);//里面接收的是可变参数类
		Person p=(Person) c.newInstance(null);//person
		System.out.println(p.name);//aaaa
	}
	//public Person(String name)
	@Test
	public void test2() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Constructor c=clazz.getConstructor(String.class);
		Person p=(Person) c.newInstance("abc");//person name
		System.out.println(p.name);//abc
	}
	
	//public Person(String name,int password)
	@Test
	public void test3() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Constructor c=clazz.getConstructor(String.class,int.class);
		Person p=(Person) c.newInstance("abc",999);//person name password
		System.out.println(p.name);//abc
	}
	//private Person(List list)
	@Test
	public void test4() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Constructor c=clazz.getDeclaredConstructor(List.class);//得到私有的构造函数
		c.setAccessible(true);//暴力反射--就是说,不管这个构造函数是什么访问权限,我来打开这个访问权限
		Person p=(Person) c.newInstance(new ArrayList());//list
		System.out.println(p.name);//aaaa
		//心得:私有的东西不能被外界访问,但是,反射可以做到!!
	}
	//创建对象的另外一种途径:以下代码等效于text1();
	@Test
	public void test5() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		//但是,反射的是类的无参的构造函数,所以,最好在创建类时,创建一个无参的构造函数
		Person p=(Person) clazz.newInstance();
		System.out.println(p.name);//aaaa
	}
}
