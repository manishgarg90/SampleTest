package com.tejas.test.collection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RetainTest {

	public static void main(String[] args) {
		List<String> a = Stream.of("1", "2", "3", "3").collect(Collectors.toList());
		List<String> a1 = Stream.of("1", "21", "3").collect(Collectors.toList());

		a.removeAll(a1);
		System.out.println(a);
	}
}
