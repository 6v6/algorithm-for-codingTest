package Greedy;

import java.util.Arrays;

public class enforcementCamera {
	public int solution(int[][] routes) {
		int answer = 0;

		// 시작 지점으로 정렬
		Arrays.sort(routes, (n1, n2) -> {
			return Integer.compare(n1[0], n2[0]);
		});

		// 첫번째 값을 기준으로
		int start = routes[0][0];
		int end = routes[0][1];
		answer++;

		for (int i = 1; i < routes.length; i++) {
			if (routes[i][0] <= end) {
				start = routes[i][0];
				if (routes[i][1] <= end)
					end = routes[i][1];
			} else {
				answer++;
				start = routes[i][0];
				end = routes[i][1];
			}
		}
		return answer;
	}
}
