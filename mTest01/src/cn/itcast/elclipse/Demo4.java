package cn.itcast.elclipse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo4 {
	@Before
	public void before(){
		System.out.println("before");
	}
	
	@Test
	public void testRun()
	{
		Person p=new Person();
		p.run();
	}
	@Test
	public void testEat(){
		Person p=new Person();
		p.eat();		
	}
	@After
	public void after(){
		System.out.println("after");
	}
}
