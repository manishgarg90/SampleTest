package com.tejas.ip;

import java.net.InetAddress;

public class TestIP {

	public static void main(String[] args) throws Exception {
		System.out.println(InetAddress.getLocalHost().getHostAddress());
	}
}
