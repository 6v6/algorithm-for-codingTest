package Graph;

import java.util.LinkedList;
import java.util.Queue;

//���� �� ���
/*
 * bfs�� ������� �ʰ�, ���� Ž���Ϸ� �ߴµ� fail..
 * ť�� �̿��� bfs�� �ذ�  
 * ��Ʈ ������ ������ ������ ť�� ���
 * ������ �ݺ������� ť�� ��� �ִ� ������ �� = ���� �� ����� ��
 */
public class farthestNode {
	static boolean map[][];
	static boolean visit[];

	public int bfs(Queue<Integer> q, int n) {

		int check = 0;

		while (!q.isEmpty()) {
			// ������ �ݺ�������, ť�� ���� �ִ� ������ ���� �ָ� ������ �ִ� ������.
			int loop = q.size();

			for (int i = 0; i < loop; i++) {
				int current = q.poll();
				for (int j = 0; j < n; j++) {
					// ����Ǿ� �ְ�, �湮���� ���� ��常 ť�� �߰�
					if (map[j][current] && !visit[j]) {
						visit[j] = true;
						q.add(j);
					}
				}
			}
			check = loop;
		}

		return check;
	}

	public int solution(int n, int[][] edge) {
		int answer = 0;
		visit = new boolean[n];
		map = new boolean[n][n];
		for (int i = 0; i < edge.length; i++) {
			map[edge[i][0] - 1][edge[i][1] - 1] = true;
			map[edge[i][1] - 1][edge[i][0] - 1] = true;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visit[0] = true;

		answer = bfs(q, n);
		return answer;
	}
}
