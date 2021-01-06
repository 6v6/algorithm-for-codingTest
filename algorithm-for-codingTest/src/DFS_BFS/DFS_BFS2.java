package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	private int x;
	private int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

//미로탈출(최단거리) - BFS이용
public class DFS_BFS2 {

	public static int n, m;
	public static int[][] graph = new int[201][201];
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void bfs(int x, int y) {
		
		Queue<Node> qu = new LinkedList<>();
		qu.offer(new Node(x, y));

		while (!qu.isEmpty()) {
			Node node = qu.poll();
			x = node.getX();
			y = node.getY();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if (graph[x][y] == 0)
					continue;

				if (graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] + 1;
					qu.offer(new Node(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(graph[n - 1][m - 1]);
	}

}
