package com.tejas.test.map.concourrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest implements Runnable {

	private Map<String, Integer> map = new ConcurrentHashMap<>();

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			String key = String.valueOf(i);
			if (!map.containsKey(key)) {
				System.out.println(Thread.currentThread().getName() + " :: insert :: " + key + " :: Hello :: "
						+ map.get(key) + " :: " + map);
				Integer ss = map.putIfAbsent(key, map.getOrDefault(key, 0) + 1);
				System.out.println(Thread.currentThread().getName() + " :: " + i + " :: " + " :: AfterInsert :: " + ss
						+ " :: " + map.get(key));
			} else {
				System.out.println(Thread.currentThread().getName() + " :: " + i + " :: " + " :: KeyFound EKS :: "
						+ ":: " + map.get(key));
			}

			try {
				int ii = Integer.parseInt(Thread.currentThread().getName());
				Thread.sleep(ii);
			} catch (InterruptedException e) {
			}
//			System.out.println(map.get(key));
		}
	}

	public void run1() {
		for (int i = 0; i < 100; i++) {
			String key = String.valueOf(i);
			if (!map.containsKey(key)) {
				synchronized (map) {
					System.out.println(Thread.currentThread().getName() + " :: insert :: " + key + " :: Hello :: "
							+ map.get(key) + " :: " + map);

					if (!map.containsKey(key)) {
						Integer ss = map.putIfAbsent(key, map.getOrDefault(key, 0) + 1);
						System.out.println(Thread.currentThread().getName() + " :: " + i + " :: "
								+ " :: AfterInsert :: " + ss + " :: " + map.get(key));
					} else {
						System.out.println(Thread.currentThread().getName() + " :: " + i + " :: " + " :: KeyFound :: "
								+ ":: " + map.get(key));
					}
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " :: " + i + " :: " + " :: KeyFound EKS :: "
						+ ":: " + map.get(key));
			}

			try {
				int ii = Integer.parseInt(Thread.currentThread().getName());
				Thread.sleep(ii);
			} catch (InterruptedException e) {
			}
//			System.out.println(map.get(key));
		}
	}

	public static void main(String[] args) {

		ConcurrentHashMapTest c = new ConcurrentHashMapTest();
		Thread t1 = new Thread(c, "1000");
		Thread t2 = new Thread(c, "2000");
		Thread t3 = new Thread(c, "3000");

		t1.start();
		t2.start();
		t3.start();
	}
}
