package Graph;

import java.util.LinkedList;
import java.util.Queue;

//가장 먼 노드
/*
 * bfs를 사용하지 않고, 선형 탐색하려 했는데 fail..
 * 큐를 이용한 bfs로 해결  
 * 루트 노드부터 인접한 노드들이 큐에 담김
 * 마지막 반복문에서 큐에 담겨 있는 노드들의 수 = 가장 먼 노드의 수
 */
public class farthestNode {
	static boolean map[][];
	static boolean visit[];

	public int bfs(Queue<Integer> q, int n) {

		int check = 0;

		while (!q.isEmpty()) {
			// 마지막 반복문에서, 큐에 남아 있는 값들이 가장 멀리 떨어져 있는 노드들임.
			int loop = q.size();

			for (int i = 0; i < loop; i++) {
				int current = q.poll();
				for (int j = 0; j < n; j++) {
					// 연결되어 있고, 방문하지 않은 노드만 큐에 추가
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
