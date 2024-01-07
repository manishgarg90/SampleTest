package com.tg.cg2023.sf1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CandidateCode1 {

	public static int getPosition(long[] nPeopleList, int n, long no) {
		int start = 0;
		int end = n - 1;

		if (nPeopleList[start] < no) {
			return start;
		}

		if (nPeopleList[end] > no) {
			return end + 1;
		}

		while (start <= end) {
			int mid = (start + end) / 2;
			if (nPeopleList[mid] == no)
				return mid;
			else if (nPeopleList[mid] < no)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return end + 1;
	}

	// 5 3 120 100 100 90 60 40 40 80
	// 5 3 120 100 100 90 60 40 80 120

	public static void insert(long[] nPeopleList, int n, int pos, long no) {

		int i;
		for (i = n - 1; (i >= pos); i--) {
			nPeopleList[i + 1] = nPeopleList[i];
		}

		nPeopleList[i + 1] = no;
	}

	public static void updateMap(Map<Long, Integer> updatedMap, long[] nPeopleList, int k, int len) {
		int rank = 1;

		if (k > 0) {
			rank = updatedMap.get(nPeopleList[k - 1]) + 1;
		}
		for (int i = k; i < len; i++) {
			long val = nPeopleList[k];
			if (!updatedMap.containsKey(val)) {
				updatedMap.put(val, rank++);
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int n = sc.nextInt();
			int p = sc.nextInt();

			long[] nPeople = new long[n + p];

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
			int len = n;
			for (int i = 0; i < p; i++) {
				long val = sc.nextLong();

				if (!updatedMap.containsKey(val)) {
					int k = getPosition(nPeople, len, val);
					insert(nPeople, len, k, val);
					len++;
					updateMap(updatedMap, nPeople, k, len);
				}

				System.out.println(updatedMap.get(val));
			}
		} finally {
		}
	}
	// 5 15 120 100 100 100 90 60 120 120 120 120 100 100 100 90 90 90 60 55 55 40
	// 5 15 120 100 100 100 90 60 120 120 120 120 100 100 100 90 90 90 60 55 50 40
}
