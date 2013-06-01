package cn.itcast.enumeration2;

import org.junit.Test;

public class Demo1 {
	@Test
	public void test() {
		print(Grade.B);	//89-80,��	
	}
    
	public void print(Grade g) // A B C D E
	{
		String value=g.getValue();
		String value2=g.localeValue();
		
		System.out.println(value+","+value2);
	}
}

//带抽象方法的枚举
enum Grade {// class A 100-90�� B 89-80�� C 79-70 һ��D 69-60�� E 59-0������
	A("100-90"){
		public String localeValue(){
			return "优";
		}
	},
	B("89-80"){
		public String localeValue(){
			return "良";
		}
	},
	C("79-70"){
		public String localeValue(){
			return "一般";
		}
	},
	D("69-60"){
		public String localeValue(){
			return "差";
		}
	}, 
	E("59-0"){
		public String localeValue(){
			return "不及格";
		}
	};// object
	
	private String value;
	private Grade(String value){
		this.value=value;
	}
	public String getValue(){
		return this.value;
	}
	public abstract String localeValue();
}
