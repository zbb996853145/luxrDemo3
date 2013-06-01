package cn.itcast.elclipse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Demo5 {
	@BeforeClass
	public void beforeClass(){
		System.out.println("beforeclass");
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
	@AfterClass
	public void afterClass(){
		System.out.println("afterclass");
	}
}
