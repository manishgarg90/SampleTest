package com.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueCharacterFrequencies {

	public int minDeletions(String s) {

		char[] c = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		for (char cc : c) {
			map.put(cc, map.getOrDefault(cc,0) + 1);
		}

		Set<Integer> countSet = new HashSet<>();

		int delete = 0;
		for (char cc : map.keySet()) {
			int count = map.get(cc);
			if (countSet.contains(count)) {
				while (countSet.contains(count)) {
					delete++;
					count--;
				}
			}
			if (count != 0)
				countSet.add(count);
		}
		return delete;
	}

	private void execute() {
//		System.out.println(minDeletions("ceabaacb"));
//		System.out.println(minDeletions("aab"));
//		System.out.println(minDeletions("aaabbbcc"));
		System.out.println(minDeletions("bbcebab"));
	}

	public static void main(String[] args) {
		new UniqueCharacterFrequencies().execute();
	}
}
