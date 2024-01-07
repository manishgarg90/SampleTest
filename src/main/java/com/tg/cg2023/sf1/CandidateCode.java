package com.tg.cg2023.sf1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CandidateCode {

	public static int getPosition(List<Long> nPeopleList, int n, long no) {
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nPeopleList.get(mid) == no)
				return mid;
			else if (nPeopleList.get(mid) < no)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return end + 1;
	}

	// 5 3 120 100 100 90 60 40 40 80
	// 5 3 120 100 100 90 60 40 80 120

	public static void updateMap(Map<Long, Integer> updatedMap, List<Long> nPeopleList, int k) {
		int rank = 1;

		if (k > 0) {
			rank = updatedMap.get(nPeopleList.get(k - 1)) + 1;
		}
		for (int i = k; i < nPeopleList.size(); i++) {
			long val = nPeopleList.get(k);
			if (!updatedMap.containsKey(val)) {
				updatedMap.put(val, rank++);
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int n = sc.nextInt();
			int p = sc.nextInt();

			long[] nPeople = new long[n];

			List<Long> nPeopleList = new ArrayList<>();
			Map<Long, Integer> updatedMap = new HashMap<>();
			int rank = 1;

			for (int i = 0; i < n; i++) {
				nPeople[i] = sc.nextLong();
				nPeopleList.add(nPeople[i]);
				if (!updatedMap.containsKey(nPeople[i])) {
					updatedMap.put(nPeople[i], rank++);
				}
			}

			for (int i = 0; i < p; i++) {
				long val = sc.nextLong();

				if (!updatedMap.containsKey(val)) {
					int k = getPosition(nPeopleList, nPeopleList.size(), val);
					nPeopleList.add(k, val);
					updateMap(updatedMap, nPeopleList, k);
				}

				System.out.println(updatedMap.get(val));
			}
		} finally {
		}
	}
	// 5 11 120 100 100 100 90 60 120 120 120 120 100 100 100 90 90 90 60 55 55 40
	// 30
}
