package com.tejas.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile(".*SYSLOG.*", 0);

		Matcher m = pattern.matcher(
				"SYSLOG-TJ5500##SourceIP=127.0.0.1##UserName=Administrator##TimeStamp=2023-12-04 17:28:24.306##LoggingStatus=SUCCESS##ActivityDone=#Operation:ResyncEMS#emsname:EMS-44#ChangeString:ModuleName=Topology,ChangedObject=,AdditionalInfo=");

		System.err.println(m.matches());
	}
}
