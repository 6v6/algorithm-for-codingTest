package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//병사 배치하기
public class dp5 {

	static int n;
	static int[] dp = new int[2000];
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		Arrays.fill(dp, 1);

		for (int i = 0; i < n; i++) {
			al.add(sc.nextInt());
		}
		Collections.reverse(al);
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (al.get(j) < al.get(i)) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 1; i < n; i++) max = Math.max(max,dp[i]);
		
		System.out.println(n - max);
	}
}
