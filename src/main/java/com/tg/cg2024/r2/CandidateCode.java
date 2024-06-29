package com.tg.cg2024.r2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class CandidateCode {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// read no of people
			int n = sc.nextInt();
			List<Integer> nos = new ArrayList<>();
			// read weight
			for (int i = 0; i < n; i++) {
				try {
					int no = Integer.parseInt(sc.next());
					if (no > 0) {
						nos.add(no);
					}
				} catch (Exception e) {
				}
			}

			Integer[] arr = nos.toArray(new Integer[0]);
			n = nos.size();

			Map<Integer, Set<String>> wtMap = new HashMap<>();
			Map<Integer, Set<Integer>> wtArrMap = new HashMap<>();
			// form wt array
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						int no = arr[i] + arr[j];
						wtMap.putIfAbsent(no, new HashSet<>());
						wtArrMap.putIfAbsent(no, new HashSet<>());

						Set<String> wtSet = wtMap.get(no);
						Set<Integer> wtArrSet = wtArrMap.get(no);

						if (!wtSet.contains(i + "-" + j) && !(wtArrSet.contains(i) || wtArrSet.contains(j))) {
							wtSet.add(i + "-" + j);
							wtArrSet.add(i);
							wtArrSet.add(j);
						}
					}
				}
			}
			int maxTeam = 0;
			for (Entry<Integer, Set<String>> entry : wtMap.entrySet()) {
				int size = entry.getValue().size();
				if (size > maxTeam) {
					maxTeam = size;
				}
			}

			System.out.println(maxTeam);
		} finally {
		}
	}
}
