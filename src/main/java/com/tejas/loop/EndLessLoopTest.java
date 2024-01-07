package com.tejas.loop;

public class EndLessLoopTest {

	public static void main(String[] args) {

//		for (;;) {
//			System.out.print("..");
//		}
//		for (int i = -214748364; i <= 0; i = i - 10000) {
//			System.out.println(".." + i);
//		}

		for (int i = 214748364; i >= 0; i += 10000) {
			System.out.println(".." + i);
		}

	}
}
