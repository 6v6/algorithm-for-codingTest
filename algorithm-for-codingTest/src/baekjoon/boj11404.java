package baekjoon;

import java.util.Scanner;

public class boj11404 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] costs = new int[n][n];
		int INF = (int) 1e9;

		// 무한 값과 0으로 배열 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					costs[i][j] = 0;
				else
					costs[i][j] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int cost = sc.nextInt();
			if (costs[x][y] > cost)
				costs[x][y] = cost;
		}

		// 최소 비용 구하기
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (costs[i][k] + costs[k][j] < costs[i][j])
						costs[i][j] = costs[i][k] + costs[k][j];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 갈 수 없는 곳은 0으로 초기화
				if (costs[i][j] == INF)
					costs[i][j] = 0;
				System.out.print(costs[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
