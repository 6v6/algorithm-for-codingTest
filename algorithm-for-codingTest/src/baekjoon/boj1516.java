package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//게임개발
public class boj1516 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] time = new int[n];
		int[] result = new int[n];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // index 건물을 짓고 나서 지을 수 있는 건물들을 저장
		ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();// index건물을 짓기 위해 필요한 선행 건물들을 저장
		Queue<Integer> qu = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
			graph2.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n; i++) {
			int t = sc.nextInt(); // 처음 값은 시간
			time[i] = t;
			int first = sc.nextInt();
			while (first != -1) {
				graph.get(i).add(first - 1);
				graph2.get(first - 1).add(i);
				first = sc.nextInt();
			}
		}

		//맨처음 선행되는 건물이 없는 값을 담음
		int nextTime = 0;
		for (int i = 0; i < n; i++) {
			if (graph.get(i).isEmpty()) {
				qu.offer(i);
				result[i] = time[i];
				nextTime = Math.max(nextTime, result[i]);
			}
		}

		while (!qu.isEmpty()) {
			int current = qu.poll();
			int max = 0;
			for (int i = 0; i < graph2.get(current).size(); i++) {
				//현재 건물이 지어지고 다음에 지어질 수 있는 건물
				int next = graph2.get(current).get(i);
				//선행되는 건물을 처리해서 삭제
				graph.get(next).remove((Integer) current);
				//리스트가 비었다면 선행되어야하는 작업이 모두 끝난 것으로 큐에 저장
				if (graph.get(next).isEmpty()) {
					qu.offer(next);
				}
				//선행되는 작업들 중에 가장 오래 걸린 시간으로 저장
				result[next] = Math.max(result[next], result[current] + time[next]);
			}
			nextTime += max;
		}

		for (int i = 0; i < n; i++) {
			System.out.println(result[i]);
		}
	}
}
