package cn.itcast.demo;
import static java.lang.System.out; 
import static java.util.Arrays.*;

public class Demo1 {
	public static void main(String[] args) {
		out.print("main");
		int []a=new int[]{6,5,3};
		sort(a);
		for(int i:a)
			out.print(i);
	}
}
