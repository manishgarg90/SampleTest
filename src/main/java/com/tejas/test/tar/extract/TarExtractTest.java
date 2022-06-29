package com.tejas.test.tar.extract;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import org.apache.commons.compress.tar.TarEntry;
import org.apache.commons.compress.tar.TarInputStream;

public class TarExtractTest {

	public static void main(String[] args) throws IOException {

		File file = new File("/home/manishg/Card_COLT-1-1_Fdb_Entries_30_12_2021_12_39_17.tgz");

		byte buffer[] = new byte[(int) file.length()];
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
		input.read(buffer, 0, buffer.length);
		input.close();

		String temp = file.getName();
		String fileName = temp.substring(0, temp.indexOf("."));
		System.out.println(fileName);
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());

		ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
		extract(inputStream, "/home/manishg/" + fileName);

	}

	public static void extract(ByteArrayInputStream inputStream, String folderName) {
		GZIPInputStream istream = null;
		TarInputStream tin = null;
		TarEntry tarEntry = null;
		long size = 0;
		try {
			istream = new GZIPInputStream(inputStream);
			tin = new TarInputStream(istream);
			tarEntry = tin.getNextEntry();
			while (tarEntry != null) {
				File destPath = new File(folderName + File.separatorChar + tarEntry.getName());
				File parent = new File(destPath.getParent());
				parent.mkdirs();
				if (!tarEntry.isDirectory()) {
					FileOutputStream fout = new FileOutputStream(destPath);
					tin.copyEntryContents(fout);
					fout.close();
				} else {
					destPath.mkdir();
				}
				size = size + tarEntry.getSize();
				tarEntry = tin.getNextEntry();
			}
		} catch (IOException e) {
		} finally {
		}
	}

}
