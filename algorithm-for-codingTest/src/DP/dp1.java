package DP;

import java.util.Scanner;

//개미 전사
public class dp1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		int[] d = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		d[0] = input[0];
		d[1] = Math.max(input[0], input[1]);

		for (int i = 2; i < n; i++) {
			d[i] = Math.max(d[i - 1], d[i - 2] + input[i]);
		}

		System.out.println(d[n - 1]);
	}
}
