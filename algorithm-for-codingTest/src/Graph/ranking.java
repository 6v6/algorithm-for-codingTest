package Graph;

/*
 * ��ƴٰ� �����ߴµ� Ǯ�� ����� �˰��� ũ�� ��ٷ��� ���� ����..
 * ���� �̱� �л��� �̱��л��� ���� �̱�ٰ� ����, ���� �й��� �л��� �й��� �л��� ���� ���ٰ� ����
 * */
public class ranking {

	public int solution(int n, int[][] results) {
		int answer = 0;
		int[][] map = new int[n][n];

		// map i==j�� ��츸 0 �������� ������ �ǹ��ϴ� 10000�� �־���
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = 10000;
				}
			}
		}

		// results�� map�� ������Ʈ��
		for (int i = 0; i < results.length; i++) {
			map[results[i][0] - 1][results[i][1] - 1] = 1; // �̱�
			map[results[i][1] - 1][results[i][0] - 1] = -1; // ��
		}

		// ���� �̱� �л��� �̱��л��� ���� �̱�ٰ� ����
		// ���� �й��� �л��� �й��� �л��� ���� ���ٰ� ����
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

		// �� �࿡�� ���Ѱ��� ������ ������ �� �� �ִ� ������ �Ǵ�
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
