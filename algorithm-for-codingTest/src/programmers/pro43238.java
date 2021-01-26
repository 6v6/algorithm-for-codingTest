package programmers;

import java.util.Arrays;

public class pro43238 {
	public long solution(int number, int[] times) {
		long answer = 1000000000;
		Arrays.sort(times);

		long n = (long) number;
		long left = 0;
		long right = (long) times[times.length - 1] * n;

		while (left <= right) {
			long mid = (left + right) / 2;

			long sum = 0;
			for (long time : times) {
				sum += mid / time;
			}

			if (sum >= n) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return answer;
	}
}
