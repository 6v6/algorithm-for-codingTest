package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//1939 중량제한
public class boj1939 {

	static class Node {
		int y;
		long c;

		Node(int y, long c) {
			this.y = y;
			this.c = c;
		}
	}

	static ArrayList<ArrayList<Node>> al = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean[] visit = new boolean[n];
		long max = 0;
		long answer = 0;

		for (int i = 0; i < n; i++) {
			al.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			long c = sc.nextInt();

			al.get(x).add(new Node(y, c));
			al.get(y).add(new Node(x, c));

			max = Math.max(max, c);
		}

		// 시작
		int a = sc.nextInt() - 1;
		// 끝
		int b = sc.nextInt() - 1;

		long start = 0;
		long end = max;

		while (start <= end) {
			long mid = (start + end) / 2;
			if (dfs(visit, n, a, b, mid)) {
				answer = mid;
				start = mid + 1;
				// System.out.println(answer);
			} else
				end = mid - 1;
			Arrays.fill(visit, false);
		}

		System.out.println(answer);
	}

	//방문여부배열, 노드의 수, 현재값, 목적지, 최소값
	private static boolean dfs(boolean visit[], int n, int now, int b, long mid) {
		// 방문처리함
		visit[now] = true;

		if (now == b) {
			return true;
		}

		for (Node node : al.get(now)) {
			if (node.c >= mid && !visit[node.y]) {
				if (!dfs(visit, n, node.y, b, mid))
					continue;
				else
					return true;
			}
		}
		return false;
	}
}
