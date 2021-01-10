package BinarySearch;

import java.util.Arrays;

//입국심사 
//int 자료형 사용시, 범위 값을 넘어가므로 주의
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
				// mid시간에 각 심사원들이 끝낸 사람의 수
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
