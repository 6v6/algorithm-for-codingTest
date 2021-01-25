package baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//������
public class boj1766 {

	static int[] indegree = new int[32001];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = sc.nextInt();
		int m = sc.nextInt();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			int first = sc.nextInt();
			int next = sc.nextInt();
			graph.get(first).add(next);
			indegree[next]++;
		}

		for (int i = 1; i < n + 1; i++) {
			// ���������� 0�� ���� ���
			if (indegree[i] == 0)
				pq.offer(i);
		}

		while (!pq.isEmpty()) {
			int target = pq.poll();
			result.add(target);

			for (int a : graph.get(target)) {
				indegree[a]--;

				if (indegree[a] == 0)
					pq.offer(a);
			}
		}

		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			System.out.print(" ");
		}
	}
}
