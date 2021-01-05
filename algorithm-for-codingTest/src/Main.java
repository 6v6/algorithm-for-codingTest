
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		int[] a = { 3, 2, 4, 3 };
		System.out.println(solution(a, 2, 4));
	}

	public static int[] solution(int[] A, int F, int M) {


		int n = 6;
		int k = F;
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int x = M * (A.length + F) - sum; // ������� ���� ������ ��

		System.out.println(x);

		int result[] = new int[10];

		long[][] dp = new long[201][201];

		// dp[K][N] = K���� �� �� N�� ����� ��
		// �������� �� �� �ִ� �� L ( 0<=L<=N )
		// dp[K][N] = sum (dp[K-1][N-L])

		for (int i = 0; i <= n; i++) {
			dp[1][i] = 1;
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				for (int l = 0; l <= j; l++) {
					dp[i][j] += dp[i - 1][j - l];
					dp[i][j] %= 1000000000;
				}
				if (dp[i][j] == x)
					System.out.println("ddddd");
			}
		}
		System.out.println(dp[k][n]);

		return result;
	}

}

/*
 * // you can also use imports, for example: // import java.util.*;
 * 
 * // you can write to stdout for debugging purposes, e.g. //
 * System.out.println("this is a debug message");
 * 
 * class Solution { public int solution(int A, int B) { // write your code in
 * Java SE 8 } }
 */
