package cn.itcast.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

public class Demo3 {

	@Test
	public void test3(){
		Map map=new HashMap();
		//Map map2=new LinkedHashMap<K, V>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		//传统方式1
		Set set=map.keySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			String key=(String)it.next();
			String value=(String) map.get(key);
			System.out.println("key="+key+",value="+value);
		}
		//传统方式2
		Set set2=map.entrySet();
		Iterator it2=set2.iterator();
		while(it2.hasNext()){
			Map.Entry  entry=(Entry)it2.next();
			System.out.println("key="+entry.getKey()+",value="+entry.getValue());
		}
		//增强for循环取map的第1种方式
		for(Object obj:map.keySet()){
			String key2=(String)obj;
			String value2=(String)map.get(key2);
			System.out.println("key2="+key2+",value2="+value2);
		}
		//增强for循环取map的第2种方式
		for(Object obj:map.entrySet()){
			Map.Entry entry3=(Entry) obj;
			String key3=(String) entry3.getKey();
			String value3=(String) entry3.getValue();
			System.out.println("key3="+key3+",value3="+value3);
		}
		//使用增强for需要注意的几个问题:增强for只适合取数据,要修改数据或集合中的数据,要用传统方式
		int arr[]={1,2,3};
		for(int i: arr){
			i=10;
		}
		System.out.println(arr[0]); // 1
		List li=new ArrayList();
		li.add("1");
		for(Object obj : li){
			obj="888";
		}
		System.out.println(li.get(0));// 1
	}
}
