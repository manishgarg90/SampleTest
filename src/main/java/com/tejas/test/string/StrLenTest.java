package com.tejas.test.string;

public class StrLenTest {

	public static void main(String[] args) {

		String[] s = "EMS-158|10.124.181.92|1|2|16;SID=;".split(";");
		System.out.println(s.length);

		for (int i = 2; i < s.length; i++) {
			System.out.println(s[i]);
		}

	}
}
