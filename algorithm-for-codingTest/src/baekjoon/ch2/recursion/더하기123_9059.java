package baekjoon.ch2.recursion;

import java.util.Scanner;

public class 더하기123_9059 {
	public static int count(int sum, int goal) {
		if (goal < sum)
			return 0;
		if (goal == sum)
			return 1;
		int result = 0;
		for (int i = 1; i <= 3; i++) {
			result += count(sum + i, goal);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 숫자의 수

		for (int i = 0; i < n; i++) {
			int target = sc.nextInt();
			int result = count(0, target);
			System.out.println(result);
		}

	}
}
