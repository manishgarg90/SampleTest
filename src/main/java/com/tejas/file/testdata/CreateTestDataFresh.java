package com.tejas.file.testdata;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

public class CreateTestDataFresh {

	public static final int ponPortCount = 4;
	public static final int ontCountPonPort = 115;

	public static void main(String[] args) {

		String file = "/home/manishg/bharti/Node_2.csv";

		String nodeIP = "172.25.23.42";
		String snstart = "TJNW";
		String ponPortStart = "1-7-";
		String ip = nodeIP.split("\\.")[3];

		try (RandomAccessFile writer = new RandomAccessFile(file, "rw"); FileChannel channel = writer.getChannel()) {
			for (int i = 1; i <= ponPortCount; i++) {
				String ponPort = ponPortStart + i;
				for (int j = 1; j <= ontCountPonPort; j++) {
					String serailNo = snstart + String.format("%1$5s", ip + i).replace(' ', '0')
							+ String.format("%1$3s", j).replace(' ', '0');
					Ont ont = new Ont("1", serailNo, nodeIP, ponPort, 0);
					ByteBuffer buff = ByteBuffer.wrap((ont.toString() + "\n").getBytes(StandardCharsets.UTF_8));
					channel.write(buff);

					ont = new Ont("2", serailNo, nodeIP, ponPort, 2);
					buff = ByteBuffer.wrap((ont.toString() + "\n").getBytes(StandardCharsets.UTF_8));
					channel.write(buff);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String vendorHexToAscii(String vendorID) {
		if (vendorID.length() != 8) {
			throw new IllegalArgumentException();
		}

		StringBuilder result = new StringBuilder();
		Arrays.stream(vendorID.split("(?<=\\G..)")).map(x -> (char) Integer.parseInt(x, 16))
				.forEachOrdered(result::append);

		return result.toString();
	}

	public static String hexToAsciiHex(String serialNumber) {
		int partitionIdx = 8;
		StringBuilder result = new StringBuilder();

		result.append(vendorHexToAscii(serialNumber.substring(0, partitionIdx)));
		result.append(serialNumber.substring(partitionIdx));

		return result.toString();
	}

	private static final class Ont {
		private String operation = "1";
		private String serialNo;
		private String nodeIp;
		private String gponPort;
		private String customerId;
		private String serviceNameArr = "Data;Voice";
		private String vlanArr = "100;600";
		private String ontgEthPort = "";
		private String serviceType = "WiFi;WiFi";
		private String upstreamProfile = "SIP;SIP";
		private String downstreamProfile = "TejNMS-dbp_dsingress_app;TejNMS-dbp_dsingress_app";
		private int delay = 0;

		public Ont(String operation, String serialNo, String nodeIp, String ponPort, int delay) {
			this.operation = operation;
			this.serialNo = serialNo;
			this.nodeIp = nodeIp;
			this.gponPort = ponPort;
			this.customerId = "CUST-" + UUID.randomUUID().toString();
			this.delay = delay;
		}

		@Override
		public String toString() {
			return this.operation + "," + this.serialNo + "," + this.nodeIp + "," + this.gponPort + ","
					+ this.customerId + "," + this.serviceNameArr + "," + this.vlanArr + "," + this.serviceType + ","
					+ this.ontgEthPort + "," + this.upstreamProfile + "," + this.downstreamProfile + "," + this.delay;
		}

		// Operation,SerialNumber,Node
		// IP,GPONPort,CustomerID,ServiceNameArr,VlanArr,ServiceType,ONTGEthPort,UpstreamProfile,DownStreamProfile
		// 1,TJNM16100001,192.168.48.75,1-6-1,TestCustomer1,Data;Voice,100;660,HSI;WiFi,1;,Auto_WiFi_1025;Auto_WiFi_1025,

	}
}
