package com.leetcode.trick;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> list = new ArrayList<>();

		if (numRows == 0) {
			return list;
		}

		int first = 0;
		int last = 0;
		for (int i = 1; i <= numRows; i++) {
			List<Integer> no = new ArrayList<>();
			if (i == 1) {
				no.add(1);
				list.add(no);
				continue;
			}

			List<Integer> prevList = list.get(i - 2);
			no.add(first + prevList.get(0));
			for (int j = 1; j < prevList.size(); j++) {
				no.add(prevList.get(j - 1) + prevList.get(j));
			}
			no.add(last + prevList.get(prevList.size() - 1));
			list.add(no);
		}
		return list;
	}

	private void execute() {
		System.out.println(generate(5));
	}

	public static void main(String[] args) {
		new PascalTriangle().execute();
	}
}
