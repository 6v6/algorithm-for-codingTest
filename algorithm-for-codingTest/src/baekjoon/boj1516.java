package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//���Ӱ���
public class boj1516 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] time = new int[n];
		int[] result = new int[n];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // index �ǹ��� ���� ���� ���� �� �ִ� �ǹ����� ����
		ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();// index�ǹ��� ���� ���� �ʿ��� ���� �ǹ����� ����
		Queue<Integer> qu = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
			graph2.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n; i++) {
			int t = sc.nextInt(); // ó�� ���� �ð�
			time[i] = t;
			int first = sc.nextInt();
			while (first != -1) {
				graph.get(i).add(first - 1);
				graph2.get(first - 1).add(i);
				first = sc.nextInt();
			}
		}

		//��ó�� ����Ǵ� �ǹ��� ���� ���� ����
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
				//���� �ǹ��� �������� ������ ������ �� �ִ� �ǹ�
				int next = graph2.get(current).get(i);
				//����Ǵ� �ǹ��� ó���ؼ� ����
				graph.get(next).remove((Integer) current);
				//����Ʈ�� ����ٸ� ����Ǿ���ϴ� �۾��� ��� ���� ������ ť�� ����
				if (graph.get(next).isEmpty()) {
					qu.offer(next);
				}
				//����Ǵ� �۾��� �߿� ���� ���� �ɸ� �ð����� ����
				result[next] = Math.max(result[next], result[current] + time[next]);
			}
			nextTime += max;
		}

		for (int i = 0; i < n; i++) {
			System.out.println(result[i]);
		}
	}
}
