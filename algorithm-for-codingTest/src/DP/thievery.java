package DP;

//도둑질
/* 집들이 원형으로 이루어져 있기 때문에
 * 첫번째 집과 마지막집이 동시에 선택될 수 없는 경우를 나눠야 했음
 * 첫번째 집부터 ~ 마지막집을 제외하고 최대값을 계산하는 경우 하나,
 * 첫번쨰집을 제외하고 두번째 집부터 마지막집까지 최대값을 계산하는 경우 하나
 * 총 두번의 반복문을 실행하여 O(N)으로, 테스트 통과.
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

		int[] d1 = new int[n]; // 첫집이 선택되고 마지막집을 고려하지 않는 경우
		int[] d2 = new int[n]; // 첫집을 고려하지 않는 경우

		d1[0] = money[0];
		d1[1] = Math.max(money[0], money[1]);

		d2[0] = 0;
		d2[1] = money[1];

		// 일자가 아니라 동그란 경우 맨끝값과 첫값이 동시에 선택될 수 없음

		// 0~n-1까지 계산하는 경우
		for (int i = 2; i < n - 1; i++) {
			d1[i] = Math.max(money[i] + d1[i - 2], d1[i - 1]);
		}

		// 1~n까지 계산하는 경우
		for (int i = 2; i < n; i++) {
			d2[i] = Math.max(money[i] + d2[i - 2], d2[i - 1]);
		}

		answer = Math.max(d1[n - 2], d2[n - 1]);
		return answer;
	}

}
