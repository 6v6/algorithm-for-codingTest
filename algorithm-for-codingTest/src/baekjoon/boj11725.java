package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class boj11725 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		parent = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		dfs(1);

		for (int i = 2; i < n + 1; i++) {
			System.out.println(parent[i]);
		}
	}

	public static void dfs(int v) {
		visited[v] = true;

		for (int i = 0; i < graph.get(v).size(); i++) {
			if (!visited[graph.get(v).get(i)]) {
				parent[graph.get(v).get(i)] = v;
				dfs(graph.get(v).get(i));
			}
		}
	}
}
