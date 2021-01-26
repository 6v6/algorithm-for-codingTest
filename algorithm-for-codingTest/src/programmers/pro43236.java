package programmers;

import java.util.Arrays;

public class pro43236 {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		int left = 0;
		int right = distance;

		Arrays.sort(rocks);
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;

			int before = 0;
			int current = rocks[0];
			for (int i = 0; i < rocks.length; i++) {
				current = rocks[i];
				if (current - before < mid) {
					count++; // 돌제거
				} else {
					before = current;
				}
				if (count > n) {
					// 돌을 더 증가 시켜야 하므로 mid값을 감소해야함
					break;
				}
			}

			// 마지막 위치까지 추가 계산
			if (count <= n) {
				current = distance;
				if (current - before < mid) {
					count++; // 돌제거
				}
			}

			if (count > n) {
				right = mid - 1;
			} else {
				answer = mid;
				left = mid + 1;
			}

		}
		return answer;
	}
}
