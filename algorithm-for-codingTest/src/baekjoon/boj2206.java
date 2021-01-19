package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class qnode {
	int x;
	int y;
	boolean check; // 벽 부셨는지
	int count;

	public qnode(int x, int y, boolean check, int count) {
		this.x = x;
		this.y = y;
		this.check = check;
		this.count = count;
	}
}

public class boj2206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		boolean[][][] visit = new boolean[n][m][2];
		Queue<qnode> q = new LinkedList<>();
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		for (int i = 0; i < n; i++) {
			String Line = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = Line.charAt(j);
			}
		}

		q.offer(new qnode(0, 0, false, 1));
		visit[0][0][0] = true;
		int answer = 1000000;
		while (!q.isEmpty()) {
			qnode cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			int checkCount = 0;
			boolean check = cur.check;
			int curCount = cur.count + 1;

			if (check)
				checkCount = 1;

			if (cx == n - 1 && cy == m - 1) {
				answer = Math.min(answer, curCount - 1);
				continue;
			}
			

			// 방향 4개 이동
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (visit[nx][ny][checkCount])
					continue;

				if (map[nx][ny] == '1' && !check) { // 벽이고 아직 벽을 안부셨으면
					visit[nx][ny][1] = true; // 방문표시
					q.offer(new qnode(nx, ny, true, curCount)); // 벽을 부시고 넣음
				}
				if (map[nx][ny] == '0') {
					visit[nx][ny][checkCount] = true;
					q.offer(new qnode(nx, ny, check, curCount));
				}
			}
		}

		if (answer == 1000000)
			answer = -1;
		System.out.println(answer);

	}
}
