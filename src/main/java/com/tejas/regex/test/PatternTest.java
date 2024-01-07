package com.tejas.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile(
				"ont_serialnumber\\s*=\\s*'(.*?)'|ont_serialnumber\\s*like\\s*'(.*?)'|ont_serialnumber\\s*in\\s*\\((.*?)\\)");
		Matcher matcher = pattern.matcher(
				"ont_serialnumber='TJNMS'|helo ont_serialnumber like '(%Test%)' | test ont_serialnumber in ('', '', '')");
		while (matcher.find()) {

			System.out.println(matcher.groupCount());
			System.out.println(matcher.group());

			if (matcher.group(0) != null) {
				System.out.println("-0->  " + matcher.group(0));
			}

			if (matcher.group(1) != null) {
				System.out.println("-1->  " + matcher.group(1));
			}

			if (matcher.group(2) != null) {
				System.out.println("-2->  " + matcher.group(2));
			}

			if (matcher.group(3) != null) {
				System.out.println("-3->  " + matcher.group(3));
			}

		}
	}
}
