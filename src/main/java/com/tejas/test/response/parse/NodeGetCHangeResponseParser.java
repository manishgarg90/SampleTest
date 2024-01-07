package com.tejas.test.response.parse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.regex.PatternSyntaxException;

public class NodeGetCHangeResponseParser {

	public static void main(String[] args) {
		String response = "2023-12-20 12:15:09 ::ffff:192.168.222.232 tejas Change tejas SNMP_Configuration-1 -TrapDestinationsV1 ,172.28.7.168:162,10.124.0.31:162,192.168.222.231:162,192.168.222.140:162,192.168.222.233:162,192.168.222.236:162,192.168.222.232:162, -TrapDestinationsV1 ,172.28.7.168:162,10.124.0.31:162,192.168.222.231:162,192.168.222.140:162,192.168.222.233:162,192.168.222.236:162,192.168.222.232:162, 2023-12-20 12:15:09 ::ffff:192.168.222.232 tejas Add User SnmpTrap-12 -LCTName SNMPTRAP-12 -InternalCreated 0 -SnmpRowStatus 1 -IsReplicatedObject 0 -CreationInHWfailed 0 -NMSInfo -mHardwareInfo -ObjectInstanceNumber 0 -Version v1 -DestinationAddress 192.168.222.232 -SnmpPort 162 -SnmpUser -LCTName SNMPTRAP-12 -InternalCreated 0 -SnmpRowStatus 1 -IsReplicatedObject 0 -CreationInHWfailed 0 -NMSInfo -mHardwareInfo -ObjectInstanceNumber 0 -Version v1 -DestinationAddress 192.168.222.232 -SnmpPort 162 -SnmpUser 2023-12-20 12:15:09 ::ffff:192.168.222.232 tejas Change tejas Tejusers-7 -LastLoginTime 1703054709 -LastLoginTime 1703054709 2023-12-20 12:36:57 192.168.222.103 SYSTEMUSER Change User ONTG-1-1-14-3 -PhysicalStatus os_deactive -PhysicalStatus os_deactive 2023-12-20 14:27:10 ::ffff:172.22.1.179 Change tejas Tejusers-7 -LastLoginTime 1703062630 -LastLoginTime 1703062630 2023-12-20 14:27:11 ::ffff:172.22.1.179 DIAGUSER Change DIAGUSER Tejusers-5 -LastLoginTime 1703062631 -LastLoginTime 1703062631 ";

		Object[] tokens = null;
		int clmsTokenCt = 2;

		// int extraInfoTokenCount = 0;
		StringTokenizer tkzer = new StringTokenizer(response, "\r\n");
		if (tkzer.hasMoreTokens() == false) {
			throw new NoSuchElementException("ChangeUploader:Empty GetChanges Response.");
		}
		for (int i = 0; tkzer.hasMoreTokens(); i++) {
			String oneChange = tkzer.nextToken();
			try {
				tokens = oneChange.split("\t", 5 + clmsTokenCt);
			} catch (PatternSyntaxException e) {
				e.printStackTrace();
			}

			String lastModifiedTimestamp = (String) tokens[0];
			try {
				lastModifiedTimestamp = lastModifiedTimestamp.replace('-', '/');
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date timestamp = null;
				timestamp = dateFormat.parse(lastModifiedTimestamp);
				lastModifiedTimestamp = String.valueOf(timestamp.getTime());
			} catch (Exception e) {
				lastModifiedTimestamp = String.valueOf(lastModifiedTimestamp);
			}
			System.out.println("lastModifiedTimestamp : " + lastModifiedTimestamp);

			String userIp = "NotAvailable";
			String endUserName = "";
			if (clmsTokenCt == 2) {
				userIp = (String) tokens[clmsTokenCt - 2];
				endUserName = (String) tokens[clmsTokenCt - 1];
			}
			System.out.println("userIp : " + userIp);
			System.out.println("endUserName : " + endUserName);

			String operation = (String) tokens[1 + clmsTokenCt];
			String userName = (String) tokens[2 + clmsTokenCt];
			String objectName = (String) tokens[3 + clmsTokenCt];
			String changesStr = "";

			if (tokens.length == 5 + clmsTokenCt) {
				changesStr = "\t" + (String) tokens[4 + clmsTokenCt];
			}

			System.out.println("operation : " + operation);
			System.out.println("userName : " + userName);

			System.out.println("objectName : " + objectName);
			System.out.println("changesStr : " + changesStr);
		}

	}

}
