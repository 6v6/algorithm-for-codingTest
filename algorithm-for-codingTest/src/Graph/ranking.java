package Graph;

/*
 * 어렵다고 생각했는데 풀이 방법을 알고나면 크게 까다롭지 않은 문제..
 * 내가 이긴 학생이 이긴학생은 나도 이긴다고 생각, 내가 패배한 학생이 패배한 학생은 나도 진다고 생각
 * */
public class ranking {

	public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] map = new int[n][n];

		// map i==j인 경우만 0 나머지엔 무한을 의미하는 10000을 넣어줌
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = 10000;
				}
			}
		}

		// results로 map을 업데이트함
		for (int i = 0; i < results.length; i++) {
			map[results[i][0] - 1][results[i][1] - 1] = 1; // 이김
			map[results[i][1] - 1][results[i][0] - 1] = -1; // 짐
		}

		// 내가 이긴 학생이 이긴학생은 나도 이긴다고 생각
		// 내가 패배한 학생이 패배한 학생은 나도 진다고 생각
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 10000) {
						if (map[i][k] == 1 && map[k][j] == 1)
							map[i][j] = 1;
						if (map[i][k] == -1 && map[k][j] == -1)
							map[i][j] = -1;
					}
				}
			}
		}

		// 각 행에서 무한값이 없으면 순위를 알 수 있는 것으로 판단
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (map[i][j] < 10000)
					count++;
			}
			if (count == n)
				answer++;
		}

		return answer;
	}
}
