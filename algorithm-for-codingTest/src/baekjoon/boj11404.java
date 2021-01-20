package baekjoon;

import java.util.Scanner;

public class boj11404 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] costs = new int[n][n];
		int INF = (int) 1e9;

		// ���� ���� 0���� �迭 �ʱ�ȭ
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

		// �ּ� ��� ���ϱ�
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
				// �� �� ���� ���� 0���� �ʱ�ȭ
				if (costs[i][j] == INF)
					costs[i][j] = 0;
				System.out.print(costs[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
