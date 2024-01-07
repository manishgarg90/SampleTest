package com.tejas.test.date;

import java.util.Calendar;
import java.util.Date;

public class DateTruncateTest {

	public static void main(String[] args) {
//		ZonedDateTime time = ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS).withDayOfMonth(1);
//		System.out.println(time);
//
//		System.out.println(LocalDate.now());
//		System.out.println(LocalDate.now());
//
//		System.out.println(LocalTime.now());
//		System.out.println(LocalTime.now().truncatedTo(ChronoUnit.DAYS));

//		final Calendar gval = Calendar.getInstance();
//		gval.setTime(new Date());
//		modify(gval, Calendar.DAY_OF_MONTH, ModifyType.TRUNCATE);
//		return gval.getTime();
//		

//		final Date date = gval.getTime();
//		long dtime = date.getTime();
//		boolean done = false;
//
//		// truncate milliseconds
//		final int millisecs = gval.get(Calendar.MILLISECOND);
//
//		System.out.println(dtime);
//		System.out.println(millisecs);
//
//		// truncate seconds
//		final int seconds = gval.get(Calendar.SECOND);
//		dtime = dtime - millisecs;
//		dtime = dtime - (seconds * 1000L);
//
//		// truncate minutes
//		final int minutes = gval.get(Calendar.MINUTE);
//		dtime = dtime - (minutes * 60000L);
//
//		if (date.getTime() != dtime) {
//			date.setTime(dtime);
//			gval.setTime(date);
//		}

		System.out.println(truncateTime(new Date()));
	}

	public static Date truncateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		long time = cal.get(Calendar.MILLISECOND) + (cal.get(Calendar.SECOND) * 1000L)
				+ (cal.get(Calendar.MINUTE) * 60000L);
		time = date.getTime() - time;

		date.setTime(time);
		cal.setTime(date);
		return cal.getTime();
	}
}
