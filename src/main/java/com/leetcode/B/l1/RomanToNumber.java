package com.leetcode.B.l1;

/**
 * M -> 1000 D -> 500 C -> 100 L -> 50 X -> 10 V -> 5 I -> 1
 * 
 * @author manishg
 *
 */
public class RomanToNumber {

	public static int romanToInt(char roman) {
		switch (roman) {
		case 'M':
			return 1000;
		case 'D':
			return 500;
		case 'C':
			return 100;
		case 'L':
			return 50;
		case 'X':
			return 10;
		case 'V':
			return 5;
		default:
			return 1;
		}
	}

	public static int romanToInt(String s) {

		char[] roman = s.toUpperCase().toCharArray();

		int count = 0;
		for (int i = 0; i < roman.length; i++) {
			int no = romanToInt(roman[i]);
			int nextNo = 0;

			System.out.println("no -> " + no + ", \tnextno: " + nextNo);
			if (i + 1 < roman.length)
				nextNo = romanToInt(roman[i + 1]);

			if (no < nextNo) {
				i++;
				count += nextNo - no;
			} else {
				count += no;
			}
		}

		return count;
	}

	public static void main(String[] args) {
//		System.out.println(romanToInt("XXIV"));
//		System.out.println(romanToInt("III"));
//		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("LCLIXIVI"));
	}

}
