package com.leetcode.trick.calendar;

import java.util.TreeMap;

public class Calendar1 {

	class MyCalendar {

		TreeMap<Integer, Integer> map = null;

		public MyCalendar() {
			map = new TreeMap<>();
		}

		public boolean book(int start, int end) {

			if (map.floorEntry(start) != null && map.floorEntry(start).getValue() > start) {
				return false;
			}

			if (map.ceilingEntry(start) != null && map.ceilingEntry(start).getKey() < end) {
				return false;
			}

			map.put(start, end);

			return true;
		}
	}

	private void execute() {
		MyCalendar myCalendar = new MyCalendar();
		System.out.println(myCalendar.book(10, 20));
		System.out.println(myCalendar.book(15, 25));
		System.out.println(myCalendar.book(20, 30));
		System.out.println(myCalendar.book(40, 50));
		System.out.println(myCalendar.book(35, 45));
		System.out.println(myCalendar.book(80, 100));
		System.out.println(myCalendar.book(65, 75));

	}

	public static void main(String[] args) {
		new Calendar1().execute();
	}
}
