package tk.bluebells.test;

import java.util.*;

public class Arraylist {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("1");
		list.add("1");
		list.add(1,"12");
		list.set(2,"a");
		list.remove("1"); //索引最小
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i)); //get()默认返回对象
		}
		System.out.println(list.contains(21));
	}
}
