package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {

	Map<String, Boolean> memo = new HashMap<>();

	public int numMatchingSubseq(String s, String[] words) {

		int count = 0;

		Map<String, Integer> map = new HashMap<>();

		for (String word : words) {
			map.putIfAbsent(word, 0);
			map.put(word, map.get(word) + 1);
		}

		for (String word : map.keySet()) {
			int j = 0;
			int i = 0;

			boolean foundMatch = true;
			while (i < word.length()) {
				if (j >= s.length()) {
					foundMatch = false;
					break;
				}

				if (word.charAt(i) == s.charAt(j)) {
					i++;
				}
				j++;
			}

			if (foundMatch) {
				count += map.get(word);
			}
		}
		return count;
	}

	private void execute() {
		System.out.println(numMatchingSubseq("abcde", new String[] { "a", "bb", "acd", "ace" }));
//		System.out
//				.println(numMatchingSubseq("dsahjpjauf", new String[] { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" }));

	}

	public static void main(String[] args) {
		new NumberOfMatchingSubsequences().execute();
	}
}
