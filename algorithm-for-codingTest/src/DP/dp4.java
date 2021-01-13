package DP;

import java.util.Scanner;

//금광
public class dp4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 0; k < t; k++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] dp = new int[n][m]; // 00 01 02 10 11(3,4)
			// 입력 값으로 dp초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					dp[i][j] = sc.nextInt();
				}
			}

			int left_up, left, left_down;
			for (int j = 1; j < m; j++) { // 00 10 20 ... n0
				for (int i = 0; i < n; i++) {
					if (i == 0)
						left_up = 0;
					else
						left_up = dp[i - 1][j - 1];

					left = dp[i][j - 1];

					if (i == n - 1)
						left_down = 0;
					else
						left_down = dp[i + 1][j - 1];

					dp[i][j] += Math.max(left_down, Math.max(left, left_up));
				}
			}

			int result = 0;
			for (int i = 0; i < n; i++) {
				result = Math.max(result, dp[i][m - 1]);
			}
			System.out.println(result);
		}
	}
}
