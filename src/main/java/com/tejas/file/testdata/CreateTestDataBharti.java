package com.tejas.file.testdata;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CreateTestDataBharti {

	private static int nProcessors = Runtime.getRuntime().availableProcessors();

	public static void main(String[] args) {
		String file = "/home/manishg/bharti/Node2.txt";
		List<String> s = null;

		try (FileChannel channel = FileChannel.open(Paths.get(file), StandardOpenOption.READ)) {
			long fileSize = channel.size();
			long chunkSize = (fileSize + nProcessors - 1) / nProcessors;
			long pos = 0;

			List<MappedByteBuffer> buffers = new ArrayList<>(nProcessors);

			for (int i = 0; i < nProcessors; i++) {
				long endPosition = getEndPosition(channel, pos + chunkSize);
				long size = endPosition - pos;
				MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, pos, size);
				pos = pos + size;
				buffers.add(buffer);
			}

			s = readBufferAndCalculateMeauremenst(buffers);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// writeProfile
		file += ".csv";

		try (RandomAccessFile writer = new RandomAccessFile(file, "rw"); FileChannel channel = writer.getChannel()) {

			for (String str : s) {
				ByteBuffer buff = ByteBuffer.wrap((str + "\n").getBytes(StandardCharsets.UTF_8));
				channel.write(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static List<String> readBufferAndCalculateMeauremenst(List<MappedByteBuffer> chunks) {

		return chunks.parallelStream().map(buffer -> {
			List<String> list = new ArrayList<>();
			int lineStart = 0;
			int doubleStart = 0;
			int length = buffer.limit();
			String serialNumber = null;
			for (int i = 0; i < length; ++i) {
				byte b = buffer.get(i);
				if (b == ',') {
					byte[] serialNumberBuffer = new byte[i - lineStart];
					buffer.position(lineStart);
					buffer.get(serialNumberBuffer);
					serialNumber = new String(serialNumberBuffer, StandardCharsets.UTF_8);
					doubleStart = i + 1;
				} else if (b == '\n') {
					byte[] objectNameBuffer = new byte[i - doubleStart];
					buffer.position(doubleStart);
					buffer.get(objectNameBuffer);
					String objectName = new String(objectNameBuffer, StandardCharsets.UTF_8);

					lineStart = i + 1;

					Ont ont = new Ont(serialNumber, objectName);
					list.add(ont.toString());
				}
			}
			return list;
		}).reduce(new ArrayList<>(), (list1, list2) -> {
			if (list1 != null && list2 != null) {
				list1.addAll(list2);
			} else if (list2 != null) {
				return list2;
			}
			return list1;
		});
	}

	private static long getEndPosition(FileChannel channel, long position) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1);
		while (position < channel.size()) {
			channel.read(buffer, position);

			if (buffer.get(0) == '\n') {
				return position + 1;
			}
			position++;
			buffer.clear();
		}
		return channel.size();
	}

	public static String vendorHexToAscii(String vendorID) {
		if (vendorID.length() != 8) {
			throw new IllegalArgumentException();
		}

		StringBuilder result = new StringBuilder();
		Arrays.stream(vendorID.split("(?<=\\G..)")).map(x -> (char) Integer.parseInt(x, 16))
				.forEachOrdered(x -> result.append(x));

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
		private String upstreamProfile = "Auto_WiFi_1025;Auto_WiFi_1025";
		private String downstreamProfile = "";

		public Ont(String serialNo, String objectName) {
			this.serialNo = hexToAsciiHex(serialNo);
			String[] objectArr = objectName.split("\\|");
			this.nodeIp = objectArr[1];
			this.gponPort = objectArr[2];
			this.customerId = "CUST-" + UUID.randomUUID().toString();
		}

		@Override
		public String toString() {
			return this.operation + "," + this.serialNo + "," + this.nodeIp + "," + this.gponPort + ","
					+ this.customerId + "," + this.serviceNameArr + "," + this.vlanArr + "," + this.serviceType + ","
					+ this.ontgEthPort + "," + this.upstreamProfile + "," + this.downstreamProfile;
		}

		// Operation,SerialNumber,Node
		// IP,GPONPort,CustomerID,ServiceNameArr,VlanArr,ServiceType,ONTGEthPort,UpstreamProfile,DownStreamProfile
		// 1,TJNM16100001,192.168.48.75,1-6-1,TestCustomer1,Data;Voice,100;660,HSI;WiFi,1;,Auto_WiFi_1025;Auto_WiFi_1025,

	}
}
