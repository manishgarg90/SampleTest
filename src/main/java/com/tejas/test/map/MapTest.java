package com.tejas.test.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("11", "1");
		map.put("12", "1");
		map.put("13", "1");

		Iterator<String> itr = map.keySet().iterator();

		while (itr.hasNext()) {
			String key = itr.next();
			System.out.println(key);
			// map.remove(key);
			itr.remove();
		}

		System.out.println(map);
//		for (String key : map.keySet()) {
//			System.out.println(map.get(key));
//			map.remove(key);
//		}

	}

}
