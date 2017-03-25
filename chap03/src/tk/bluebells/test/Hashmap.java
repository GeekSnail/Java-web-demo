package tk.bluebells.test;

import java.util.*;

public class Hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("苹果", "2.5");
		map.put("桔子", "2.5");
		map.put("香蕉", "3");
		
		map.remove("桔子");
		map.put("菠萝", "5");
		
		System.out.println("个数是："+map.size());
		Set<String> set = map.keySet(); //返回当前容器中所有的名称
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			//获得名称
			String name = (String)iterator.next();
			//获得数值
			String value = (String)map.get(name);
			System.out.println(name+":"+value);
			
		}
	}

}
