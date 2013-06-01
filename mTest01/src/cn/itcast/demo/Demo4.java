package cn.itcast.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Demo4 {
	@Test
	public void testSum(){
		sum(1,2,3,4);
		int arr[]={5,6,7};
		sum(arr);
	}
	public void sum(int ...nums){
		//可变参数就把它看成数组
		int sum=0;
		for(int i:nums){
			sum+=i;
		}
		System.out.println(sum);		
	}
	
	//可变参数需要注意的问题
	//public void aa(int ...nums,int s){}//不行error
	//public void bb(int s ,int ...nums)//可以,right
	@Test
	public void  bb(){
		//public static <T> List<T> asList(T... a)
		List list=Arrays.asList("1","2","3");//对象类型
		System.out.println(list);//[1, 2, 3]
		
		String arr[]={"1","2","3","4"};//对象类型
		list=Arrays.asList(arr);
		System.out.println(list);//[1, 2, 3, 4]
		
		int nums[]={1,2,3,4,5};	//基本类型
		list=Arrays.asList(nums);
		System.out.println(list);//[[I@120d62b]
		/**
		 * 对象类型还是基本类型???	这个细节一定要小心
		 */
		Integer nums2[]={1,2,3,4,5};	//对象类型
		list=Arrays.asList(nums2);
		System.out.println(list);//[1, 2, 3, 4, 5]
		
	}
}
