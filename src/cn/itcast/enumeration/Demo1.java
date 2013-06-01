package cn.itcast.enumeration;

import org.junit.Test;

public class Demo1 {
	@Test
	public void test() {
		print(Grade.B);
	}

	public void print(Grade g) // A B C D E
	{
		String value = g.getValue();
		System.out.println(value);
	}
}

/*
 * class Grade{ 
 * 
 * 		private Grade(){ } 
 * 		public static final Grade A=new Grade();
 * 		public static final Grade B=new Grade(); 
 * 		public static final Grade C=newGrade(); 
 * 		public static final Grade D=new Grade(); 
 * 		public static final GradeE=new Grade(); 
 * }
 */

/**
 *  相当于上面的class Grade{}
 *  如何定义枚举的构造函数/方法和字段,去封装更多的信息
 */
enum Grade {// class A 100-90 B 89-80 C 79-70 D 69-60 E 59-0
	A("100-90"), B("89-80"), C("79-70"), D("69-60"), E("59-0");// object
	private String value;

	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
