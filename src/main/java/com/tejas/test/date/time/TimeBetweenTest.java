package com.tejas.test.date.time;

import java.time.Duration;
import java.time.Instant;

public class TimeBetweenTest {

	public static void main(String[] args) throws InterruptedException {

		Instant start = Instant.now();

		Thread.sleep(2000);

		System.out.println(Duration.between(start, Instant.now()).toMillis());

		System.out.println(start.toString());

		System.out.println(start.toEpochMilli());
	}
}
