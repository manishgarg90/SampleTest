package com.tejas.test.dq;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLinkedDQEx {

	private static ConcurrentLinkedDeque<String> fdfrList = new ConcurrentLinkedDeque<>();

	public void submit(String s) {
		fdfrList.add(s);
		fdfrList.notify();
	}

	public static void main(String[] args) {
		ConcurrentLinkedDQEx ss = new ConcurrentLinkedDQEx();

		ExecutorService exe = Executors.newFixedThreadPool(1);
		exe.submit(new Runnable() {

			@Override
			public void run() {
				while (true) {

					if (fdfrList.isEmpty()) {
						try {
							System.out.println("WAITINg");
							fdfrList.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					System.out.println(" ----> " + fdfrList.poll() + "   -------    Size: ---" + fdfrList.size());
				}
			}
		});

		for (int i = 0; i < 5; i++) {
			new Producer("TT" + i, ss).start();
		}

	}
}

class Producer extends Thread {

	private String s;

	private ConcurrentLinkedDQEx obj;

	public Producer(String s, ConcurrentLinkedDQEx obj) {
		this.s = s;
		this.obj = obj;
	}

	@Override
	public void run() {

		int i = 0;

		while (true) {
			obj.submit(s + "-" + i);
			i++;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
		}

	}
}
