package com.tg.cg2023.sf2;

public class CombinationTest {

	private String inputstring;
	private StringBuilder output = new StringBuilder();

	public CombinationTest(String str) {
		inputstring = str;
	}

	public void combine(int start) {
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));
			System.out.println(output + "---" + inputstring.substring(i + 1));
			if (i < inputstring.length())
				combine(i + 1);
			output.setLength(output.length() - 1);
		}
	}

	public static void main(String[] args) {
		new CombinationTest("123").combine(0);
	}
}
