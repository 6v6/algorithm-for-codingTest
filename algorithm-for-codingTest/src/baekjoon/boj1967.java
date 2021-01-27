package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj1967 {
	static class Node {
		int y;
		int cost;

		Node(int y, int cost) {
			this.y = y;
			this.cost = cost;
		}
	}

	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	static int n;
	static int max = 0;
	static int endNode = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		boolean[] visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			tree.add(new ArrayList<Node>());
		}

		for (int i = 0; i < n - 1; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int cost = sc.nextInt();
			tree.get(y).add(new Node(x, cost));
			tree.get(x).add(new Node(y, cost));
		}

		
		//1. 루트 노드에서 가장 거리가 먼 노드를 찾는다.
		dfs(0, 0, visit);
		
		Arrays.fill(visit, false);
		
		//2. 1에서 찾은 가장 먼 노드를 기준으로 가장 거리가 먼 노드를 찾아 트리의 지름을 구한다.
		dfs(endNode, 0, visit);
		
		System.out.println(max);
	}

	private static void dfs(int cur, int sum, boolean[] visit) {
		
		visit[cur] = true;
		if (max < sum) {
			max = sum;
			endNode = cur;
		}

		

		for (int i = 0; i < tree.get(cur).size(); i++) {
			if (visit[tree.get(cur).get(i).y]) continue;
			dfs(tree.get(cur).get(i).y, sum + tree.get(cur).get(i).cost, visit);
		}
	}

	/*
	 * 이전에 성공한 코드 (더욱 효율적인 방법이 있어 위와같이 수정함) public static void main(String[] args) {
	 * Scanner sc = new Scanner(System.in); n = sc.nextInt();
	 * 
	 * boolean[] visit = new boolean[n]; boolean[] leafCheck = new boolean[n]; for
	 * (int i = 0; i < n; i++) { tree.add(new ArrayList<Node>()); }
	 * 
	 * for (int i = 0; i < n - 1; i++) { int x = sc.nextInt() - 1; int y =
	 * sc.nextInt() - 1; int cost = sc.nextInt(); tree.get(y).add(new Node(x,
	 * cost)); tree.get(x).add(new Node(y, cost)); leafCheck[x] = true; //자식이 있으면 }
	 * 
	 * for (int i = 0; i < n; i++) { if(!leafCheck[i]) { Arrays.fill(visit, false);
	 * dfs(i, 0, visit); } }
	 * 
	 * System.out.println(max); }
	 * 
	 * private static void dfs(int cur, int sum, boolean[] visit) { if (visit[cur]
	 * == true) { max = Math.max(max, sum); return; }
	 * 
	 * visit[cur] = true;
	 * 
	 * for (int i = 0; i < tree.get(cur).size(); i++) {
	 * if(!visit[tree.get(cur).get(i).y]) dfs(tree.get(cur).get(i).y, sum +
	 * tree.get(cur).get(i).cost, visit); else { max = Math.max(max, sum); } } }
	 */
}
