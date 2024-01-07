package com.tejas.test.map;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSplitTest {

	public static void main(String[] args) {
		String s = "TPID:0x8100|PBIT:0|DEI:X|VID:101";

		Map<String, String> map = Arrays.stream(s.split("\\|")).map(str -> {
			return str.split(":");
		}).collect(Collectors.toMap(str -> str[0], str -> str[1]));

		System.out.println(map);
	}
}
