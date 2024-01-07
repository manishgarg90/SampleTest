package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindReplacePattern {

	public List<String> findAndReplacePattern(String[] words, String pattern) {

		List<String> replaceWords = new ArrayList<>();

		if (pattern.length() == 0) {
			return replaceWords;
		}

		if (pattern.length() == 1) {
			replaceWords.addAll(Arrays.stream(words).collect(Collectors.toList()));
			return replaceWords;
		}

		for (String word : words) {
			if (isPatternMatched(word, pattern)) {
				replaceWords.add(word);
			}
		}

		return replaceWords;
	}

	private boolean isPatternMatched(String word, String pattern) {

		char[] w2p = new char[26];
		char[] p2w = new char[26];

		for (int i = 0; i < pattern.length(); i++) {

			char w = word.charAt(i);
			char p = pattern.charAt(i);

			if (w2p[w - 'a'] == 0) {
				w2p[w - 'a'] = p;
			}

			if (p2w[p - 'a'] == 0) {
				p2w[p - 'a'] = w;
			}

			if (w2p[w - 'a'] != p || p2w[p - 'a'] != w) {
				return false;
			}

		}

		return true;
	}

	private void execute() {
		System.out.println(findAndReplacePattern(new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" }, "abb"));
	}

	public static void main(String[] args) {
		new FindReplacePattern().execute();
	}
}
