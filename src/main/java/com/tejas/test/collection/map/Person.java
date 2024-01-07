package com.tejas.test.collection.map;

import java.util.HashMap;
import java.util.Map;

public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

//	@Override
//	public boolean equals(Object obj) {
//		return ((Person) obj).name.equals(this.name);
//	}

	@Override
	public int hashCode() {
		return 1;
	}

	public static void main(String[] args) {
		Map<Person, Person> map = new HashMap<>();

		for (int i = 0; i < 1000; i++) {
			Person p = new Person("test");
			map.put(p, p);
		}
		System.out.println(map.keySet().size());
	}

}
