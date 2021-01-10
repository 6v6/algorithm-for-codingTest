package BinarySearch;

import java.util.Arrays;

//�Ա��ɻ� 
//int �ڷ��� ����, ���� ���� �Ѿ�Ƿ� ����
public class immigration {
	public long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;

		Arrays.sort(times);

		long left = 1;
		long right = (long) times[times.length - 1] * (long) n;
		long mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			long numbers = 0;
			for (int i = 0; i < times.length; i++) {
				// mid�ð��� �� �ɻ������ ���� ����� ��
				numbers += mid / times[i];
			}

			if (numbers >= n) {
				if (answer > mid)
					answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}
}
