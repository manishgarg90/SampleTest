package com.tejas.test.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTest {

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		Date endTime = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
		Date startTime = Date.from(date.minusDays(1l).atZone(ZoneId.systemDefault()).toInstant());

		System.out.println(date);
		System.out.println(startTime);
		System.out.println(endTime);
	}
}
