package cn.itcast.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.Test;
//反射类方法
public class Demo3 {
//   public void aa1()
	@Test
	public void test1() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Method method=clazz.getMethod("aa1", null);//方法的名称,传的参数的类
		Person p=new Person();//person
		method.invoke(p, null);//aa1//对象的方法,传的参数
	}
	//public void aa1(String name,int password)
	@Test
	public void test2() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Method method=clazz.getMethod("aa1", String.class,int.class);
		Person p=new Person();//person
		method.invoke(p, "xxxx",99);//name= xxxx password=99
	}
	//public Class[] aa1(String name,int[] password)
	@Test
	public void test3() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Method method=clazz.getMethod("aa1", String.class,int[].class);
		Person p=new Person();//person
		Class cs[]=(Class[]) method.invoke(p, "xxxx",new int[]{1,2,3});//name= xxxx password=99
		System.out.println(cs[0]);//class java.lang.String
	}
	//private void aa1(InputStream in)
	@Test
	public void test4() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Method method=clazz.getDeclaredMethod("aa1",InputStream.class);//private
		method.setAccessible(true);//暴力反射
		Person p=new Person();//person
		method.invoke(p,new FileInputStream("C:\\1.txt"));//
		
	}
	//public static void aa1(int num)
	@Test
	public void test5() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Method method=clazz.getMethod("aa1",int.class);
		method.invoke(null,777);//777  静态的方法不需要对象
	}
	
	/**
	 * 通过反射调用一个接受数组的方法时,就要小心了...
	 * @throws Exception
	 */
	//	public static void main(String []args){
	@Test
	public void test6() throws Exception{
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		Method method=clazz.getMethod("main",String [].class);
		//method.invoke(null,new String[]{"a","c"});//Wrong
		//method.invoke(null,"a","c");//Wrong
		String []str={"x","y","z"};
		method.invoke(null, (Object)str);
		method.invoke(null,  new Object[]{new String[]{"a","c"} });//拆分后正好是String[]
		method.invoke(null,  (Object)new String[]{"a","c"});
	}
	
}
