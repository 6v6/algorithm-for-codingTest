package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2056 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] indegree = new int[n];
		int[] times = new int[n];
		int[] endtime = new int[n];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		Queue<Integer> qu = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			times[i] = sc.nextInt();
			endtime[i] = times[i];
			int num = sc.nextInt();
			indegree[i] = num;
			for (int j = 0; j < num; j++) {
				int first = sc.nextInt() - 1;
				graph.get(first).add(i);
			}
		}

		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0)
				qu.add(i);
		}

		while (!qu.isEmpty()) {
			int target = qu.poll();
			for (int after : graph.get(target)) {
				indegree[after]--;
				endtime[after] = Math.max(endtime[after], endtime[target] + times[after]);
				if (indegree[after] == 0)
					qu.add(after);
			}
		}

		Arrays.sort(endtime);
		System.out.println(endtime[n - 1]);
	}
}
