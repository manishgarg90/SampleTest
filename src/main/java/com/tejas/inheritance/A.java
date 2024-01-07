package com.tejas.inheritance;

class Parent {
	public static void abc() {
		System.out.println("A");
	}
}

public class A extends Parent {
	public static void abc() {
		System.out.println("b");
	}

	public static void main(String[] args) {
		Parent a = null;
		a.abc();

		Parent a11 = null;
		a11.abc();

		A a1 = new A();
		a1.abc();
	}
}