package BF;

import java.util.Scanner;

//시각 문제
public class BF2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 60; j++) {
				for (int k = 0; k < 60; k++) {
					if (check(i, j, k))
						result++;
				}
			}
		}

		System.out.println(result);
	}

	private static boolean check(int h, int m, int s) {
		if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
			return true;
		return false;
	}

}
