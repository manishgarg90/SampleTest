package com.tejas.errortest;

public class ErrorTest {
	public static void main(String[] args) {
		try {
			throw new NullPointerException("Hello");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("exception");
		} finally {
			System.out.println("finally");
		}

	}
}
