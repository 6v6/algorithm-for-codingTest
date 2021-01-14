package DP;

//������
/* ������ �������� �̷���� �ֱ� ������
 * ù��° ���� ���������� ���ÿ� ���õ� �� ���� ��츦 ������ ����
 * ù��° ������ ~ ���������� �����ϰ� �ִ밪�� ����ϴ� ��� �ϳ�,
 * ù�������� �����ϰ� �ι�° ������ ������������ �ִ밪�� ����ϴ� ��� �ϳ�
 * �� �ι��� �ݺ����� �����Ͽ� O(N)����, �׽�Ʈ ���.
 * */
public class thievery {

	public int solution(int[] money) {
		int answer = 0;
		int n = money.length;

		if (n < 4) {
			answer = 0;
			for (int i = 0; i < n; i++) {
				answer = Math.max(answer, money[i]);
			}
			return answer;
		}

		int[] d1 = new int[n]; // ù���� ���õǰ� ���������� ������� �ʴ� ���
		int[] d2 = new int[n]; // ù���� ������� �ʴ� ���

		d1[0] = money[0];
		d1[1] = Math.max(money[0], money[1]);

		d2[0] = 0;
		d2[1] = money[1];

		// ���ڰ� �ƴ϶� ���׶� ��� �ǳ����� ù���� ���ÿ� ���õ� �� ����

		// 0~n-1���� ����ϴ� ���
		for (int i = 2; i < n - 1; i++) {
			d1[i] = Math.max(money[i] + d1[i - 2], d1[i - 1]);
		}

		// 1~n���� ����ϴ� ���
		for (int i = 2; i < n; i++) {
			d2[i] = Math.max(money[i] + d2[i - 2], d2[i - 1]);
		}

		answer = Math.max(d1[n - 2], d2[n - 1]);
		return answer;
	}

}
