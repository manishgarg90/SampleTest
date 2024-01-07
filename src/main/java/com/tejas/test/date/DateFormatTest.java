package com.tejas.test.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatTest {

	public static void main(String[] args) {

		long sec = System.currentTimeMillis();

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(sec);

		Date d = new Date();
		System.out.println(d);
		
		System.out.println(System.currentTimeMillis());
		System.out.println(d.getTime());
		
		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
	}
}
