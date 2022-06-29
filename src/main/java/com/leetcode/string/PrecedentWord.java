package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrecedentWord {

	Map<String, Integer> memo = new HashMap<>();

	public int dfs(String word, Map<Integer, List<String>> wordMap) {

		if (!wordMap.containsKey(word.length() + 1)) {
			return 1;
		}

		if (memo.containsKey(word)) {
			return memo.get(word);
		}

		List<String> nextWords = wordMap.get(word.length() + 1);
		int max = 1;

		for (String nextWord : nextWords) {
			if (canConsiderWord(nextWord, word)) {
				max = Math.max(max, 1 + dfs(nextWord, wordMap));
			}
		}

		memo.put(word, max);
		return memo.get(word);
	}

	public boolean canConsiderWord(String w1, String w2) {

		int count = 0;
		for (int i = 0, j = 0; i < w1.length() && j < w2.length() && count <= 1; i++) {
			if (w1.charAt(i) != w2.charAt(j)) {
				count++;
			} else {
				j++;
			}
		}

		return count <= 1;
	}

	public int longestStrChain(String[] words) {

		Map<Integer, List<String>> wordMap = new HashMap<>();

		for (String word : words) {
			int len = word.length();
			wordMap.putIfAbsent(len, new ArrayList<>());
			wordMap.get(len).add(word);
		}

		Arrays.sort(words, (a, b) -> a.length() - b.length());

		int max = 0;
		for (String word : words) {
			max = Math.max(max, dfs(word, wordMap));
		}

		return max;
	}

	public void execute() {
		System.out.println(longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" }));

		System.out.println(longestStrChain(new String[] { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" }));

		System.out.println(longestStrChain(new String[] { "abcd", "dbqca" }));

	}

	public static void main(String[] args) {
		new PrecedentWord().execute();
	}

}
