package tk.bluebells.test;

import java.util.*;

public class HashSetTest {
	public static void main(String[] args) {
		Set<String> set =  new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("1");
		set.add("1");
		set.remove("1");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
