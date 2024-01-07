package com.tg.cg2022.sf.r2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CandidateCode {
   public static void main(String args[] ) throws Exception {
try (Scanner sc = new Scanner(System.in)) {
			
			int s = sc.nextInt();
			int t = sc.nextInt();
			int q = sc.nextInt();

			Set<Integer> occupiedSeats = new HashSet<>();

			for (int i = 0; i < t; i++) {
            try {
			   	occupiedSeats.add(sc.nextInt());
            } catch (Exception ex) {
                continue;
            }
			}

			for (int i = 0; i < q; i++) {
				try {
					int likedSeat = sc.nextInt();
					if (!occupiedSeats.contains(likedSeat)) {
						System.out.println("Y");
					} else {
						System.out.println("N");
					}
				} catch(Exception e) {
               System.out.println("Y");
					//continue;
				}
			}
		} finally {

		}

   }
}

