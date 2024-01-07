package com.tejas.test.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SetAsKeyInMap {

	public static void main(String[] args) {

		Set<String> set1 = Arrays.stream(new String[] { "1", "2", "3", "4", "5", "6" }).collect(Collectors.toSet());

		Map<Set<String>, Object> map = new HashMap<>();
		map.put(set1, new Object());

		Set<String> set2 = Arrays.stream(new String[] { "1" }).collect(Collectors.toSet());

		System.out.println(map.containsKey(set2));

	}
}
