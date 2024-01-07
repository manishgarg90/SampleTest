package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

	public List<String> wordSubsets(String[] words1, String[] words2) {
		List<String> words = new ArrayList<>();

		int[] freqB = new int[26];
		for (String word : words2) {
			for (char a : word.toCharArray()) {
				freqB[a - 'a'] = Math.max(freqB[a - 'a'], charCount(word, a));
			}
		}

		for (String word : words1) {
			boolean found = true;
			for (char a = 'a'; a <= 'z'; a++) {
				if (charCount(word, a) < freqB[a - 'a']) {
					found = false;
				}
			}
			if (found) {
				words.add(word);
			}
		}

		return words;
	}

	private int charCount(String s, char c) {
		int cnt = 0;
		for (char a : s.toCharArray()) {
			if (a == c) {
				cnt++;
			}
		}
		return cnt;
	}

	private void execute() {
		System.out.println(wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" },
				new String[] { "eo", "lo" }));
	}

	public static void main(String[] args) {
		new WordSubsets().execute();
	}
}
