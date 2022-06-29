package com.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ScheduledCourse {

	public int scheduleCourse(int[][] courses) {

		Arrays.sort(courses, (c1, c2) -> c1[1] - c2[1]);

		PriorityQueue<Integer> q = new PriorityQueue<>((b1, b2) -> b2 - b1);

		int time = 0;
		for (int[] course : courses) {
			time += course[0];
			q.add(course[0]);

			if (time > course[1]) {
				time -= q.poll();
			}
		}
		return q.size();
	}

	private void execute() {
		int[][] arr = new int[][] { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } };
		System.out.println(scheduleCourse(arr));

//		arr = new int[][] { { 1, 2 } };
//		System.out.println(scheduleCourse(arr));

//		arr = new int[][] { { 3, 2 }, { 3, 2 } };
//		System.out.println(scheduleCourse(arr));

		arr = new int[][] { { 5, 5 }, { 4, 6 }, { 2, 6 } };
		System.out.println(scheduleCourse(arr));
	}

	public static void main(String[] args) {
		new ScheduledCourse().execute();
		;
	}
}
