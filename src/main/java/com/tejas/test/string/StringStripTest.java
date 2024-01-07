package com.tejas.test.string;

public class StringStripTest {

	public static void main(String[] args) {

		String s = "ONTGVirtualEthernetPort-1-1-1-1-3-1";
		System.out.println(s.substring(s.indexOf("ONTGVirtualEthernetPort-") + 1));
		System.out.println(s.replace("ONTGVirtualEthernetPort", "ONTGVPORT"));

		s = "ONT-1-1-1-1";
		String[] lctNameArr = s.split("-");

		System.out.println(lctNameArr[lctNameArr.length - 4] + "-" + lctNameArr[lctNameArr.length - 3] + "-"
				+ lctNameArr[lctNameArr.length - 2] + "-" + lctNameArr[lctNameArr.length - 1]);

		String str = "1-2-9-103-1";
		System.out.println(str.substring(0, str.lastIndexOf("-")));
	}
}
