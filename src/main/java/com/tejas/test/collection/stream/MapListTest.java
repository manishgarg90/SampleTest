package com.tejas.test.collection.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapListTest {

	private String s;

	public MapListTest(String s) {
		super();
		this.s = s;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "MapListTest [s=" + s + "]";
	}

	public static void main(String[] args) {

		List<MapListTest> list = Arrays
				.stream(new MapListTest[] { new MapListTest("s1"), new MapListTest("s2"), new MapListTest("s3"),
						new MapListTest("s4"), new MapListTest("s5"), new MapListTest("s3") })
				.collect(Collectors.toList());

		System.out.println(list.stream().collect(Collectors.groupingBy(MapListTest::getS)));
	}

}
