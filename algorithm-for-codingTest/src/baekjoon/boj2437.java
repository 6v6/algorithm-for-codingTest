package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//저울
public class boj2437 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		// 오름차순으로 정렬
		Arrays.sort(input);

		// 제일 작은 추의 값이 1이 아닌경우
		if (input[0] != 1) {
			System.out.println(1);
			return;
		}

		// 누적합을 담는 변수
		int sum = input[0];
		for (int i = 1; i < n; i++) {
			if (sum + 1 < input[i]) {
				answer = sum + 1;
				break;
			}
			sum += input[i];
		}

		//모든 저울을 더 한 값까지 만들 수 있는 경우
		if (answer == 0)
			answer = sum + 1;

		System.out.println(answer);

	}
}
