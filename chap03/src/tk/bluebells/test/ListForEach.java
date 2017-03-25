package tk.bluebells.test;

import java.util.Arrays;

import java.util.*;

public class ListForEach {

	public static void main(String[] args) {

		List<String> myList = Arrays.asList("你好！","中国！","新疆！","乌鲁木齐！");
		for (String s:myList) {
			System.out.println(s);
		}
	}

}
