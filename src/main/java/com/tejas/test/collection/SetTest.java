package com.tejas.test.collection;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<Integer> test = new HashSet<>();
		test.add(null);
		test.add(null);
		test.add(1);
		System.out.println(test);

		Integer t = null;
		if (t != 1) {
			System.out.println("Test");
		}
	}
}
