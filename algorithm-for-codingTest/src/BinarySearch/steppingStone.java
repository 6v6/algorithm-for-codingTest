package BinarySearch;

import java.util.Arrays;

//징검다리
public class steppingStone {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		int start = 0;
		int end = distance;
		int mid = (start + end) / 2;

		Arrays.sort(rocks);

		while (start <= end) {
			mid = (start + end) / 2;
			int pivot = 0;
			int count = 0;

			for (int i = 0; i < rocks.length; i++) {
				// 최솟값보다 작으면 바위 제거
				if (rocks[i] - pivot < mid) {
					count++;
				} else {
					pivot = rocks[i];
				}
				if (count > n)
					break;
			}

			if (distance - pivot < mid)
				count++;

			if (count <= n) {
				if (answer < mid)
					answer = mid;
				start = mid + 1;
			} else {
				end = mid - 1;

			}
		}

		return answer;
	}
}
