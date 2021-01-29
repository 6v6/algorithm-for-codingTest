package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1261 {
	static class Node{
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] graph = new int[m][n];
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int INF = (int) 1e9;
		// 최단거리 테이블
		int[][] d = new int[m][n];

		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			Arrays.fill(d[i], INF);
		}

		for (int i = 0; i < m; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(s.charAt(j) + "");
			}
		}
		
		int curX = 0;
		int curY = 0;
		int distance = 0;
		d[curX][curY] = 0;
		
		q.add(new Node(curX, curY));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			curX = node.x;
			curY = node.y;
			distance = graph[curX][curY];
			
			if(d[curX][curY] < distance) continue;

			for(int i = 0; i < 4; i++) {
				int nx = curX+dx[i];
				int ny = curY+dy[i];
				if(nx >= 0 && nx < m && ny >=0 && ny < n) {
					int cost = d[curX][curY] + graph[nx][ny];
					
					if(cost < d[nx][ny]) {
						d[nx][ny] = cost;
						q.offer(new Node(nx, ny));
					}
				}
			}
		}
		
		System.out.println(d[m-1][n-1]);
	}
}
