package tk.bluebells.test;

import java.util.*;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		Map<Integer, String> myMap = new HashMap<Integer, String>();
		myMap.put(1, "新疆");
		myMap.put(2, "北京");
		myMap.put(3, "四川");
		myMap.put(4, "河南");
		myMap.put(5, "湖南");
		myMap.put(6, "河北");
		myMap.put(7, null);
		
		System.out.println("map的大小为："+myMap.size());
		System.out.println("判断map是否为空："+myMap.isEmpty());
		System.out.println("是否存在key=2的键值对："+myMap.containsKey(2));
		System.out.println("是否存在value=“四川”的键值对："+myMap.containsValue("四川"));
		System.out.println("得到key=6的值："+myMap.get(6));
		
		myMap.remove(4);
		System.out.println("删除后的map大小为："+myMap.size());
		//将所有键以Set集合形式返回
		Set<Integer> myKeySet = myMap.keySet(); 
		System.out.println("myKeySet内容，即Map中key的值为："+myKeySet);
		//将集合中所有值以collection形式返回
		Collection<String> myMapValues = myMap.values();
		System.out.println("myMapValues内容，即Map中value的集合为："+myMapValues);
	}
}
