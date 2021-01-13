package ShortestPath;

import java.util.Arrays;
import java.util.Scanner;

//�̷�����
public class sp2 {
	public static final int INF = (int) 1e9;
	public static int[][] graph = new int[101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ȸ�� ��
		int m = sc.nextInt(); // ������ ��

		for (int i = 0; i < 101; i++) {
			Arrays.fill(graph[i], INF);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (i == j)
					graph[i][j] = 0;
		}

		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			graph[s][e] = 1;
			graph[e][s] = 1;
		}

		int x = sc.nextInt(); // ������
		int mid = sc.nextInt(); // �߰��� ���İ� ��

		for (int k = 1; k <= n; k++) {
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++)
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
			}
		}

		// 1~mid������ �ִ밪, mid~x������ �ִ밪
		int distance = graph[1][mid] + graph[mid][x];

		if (distance >= INF)
			System.out.println(-1);
		else
			System.out.println(distance);

	}
}
