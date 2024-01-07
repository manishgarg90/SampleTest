package com.tg.cg2022.sf.r1;

import java.util.Scanner;

public class CandidateCode {
	public static void main(String args[]) throws Exception {

		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				String s = String.valueOf(i);
				if (s.indexOf("2") != -1 || s.indexOf("14") != -1) {
					n++;
				}
			}
			System.out.println(n);
		}finally {
			
		}
	}
}
