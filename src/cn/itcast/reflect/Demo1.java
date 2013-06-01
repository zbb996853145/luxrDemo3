package cn.itcast.reflect;

public class Demo1 {

	//反射:加载类,获得类的字节码  以下三种方式
	public static void main(String[] args) throws Exception {
		
		//得到person类的字节码
		//1
		Class clazz=Class.forName("cn.itcast.reflect.Person");
		//2
		Class clazz1=new Person().getClass();
		//3
		Class clazz2=Person.class;
		
	}

}
