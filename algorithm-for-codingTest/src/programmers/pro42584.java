package programmers;

public class pro42584 {
	public int[] solution(int[] prices) {
		int n = prices.length;
		int[] answer = new int[n];
		answer[n - 1] = 0;
		for (int i = 0; i < n - 1; i++) {
			int target = prices[i];
			int count = 0;
			for (int j = i + 1; j < n; j++) {
				count++;
				if (prices[i] > prices[j])
					break;
			}
			answer[i] = count;
		}

		return answer;
	}
}
