package DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

//����� ����Ա�
public class DFS_BFS1 {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static int[][] graph;

	public static void main(String[] args) {

		n = sc.nextInt(); // ���α���
		m = sc.nextInt(); // ���α���
		sc.nextLine(); // ���������
		graph = new int[n][m];
		int result = 0;

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dfs(i, j))
					result++;
			}
		}

		System.out.println(result);
	}

	private static boolean dfs(int x, int y) {
		if (x <= -1 || x >= n || y <= -1 || y >= m)
			return false;

		if (graph[x][y] == 0) {
			graph[x][y] = 1;// �湮ó��
			dfs(x, y + 1); // ��
			dfs(x, y - 1); // ��
			dfs(x + 1, y); // ��
			dfs(x - 1, y); // ��
			return true;
		}
		return false;
	}
}
