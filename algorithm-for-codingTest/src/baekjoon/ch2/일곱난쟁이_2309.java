package baekjoon.ch2;

import java.util.Arrays;
import java.util.Scanner;

public class ÀÏ°ö³­ÀïÀÌ_2309 {
	public static void main(String[] args) {
		int[] input = new int[9];
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
			sum += input[i];
		}

		Arrays.sort(input);
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - input[i] - input[j] == 100) {
					for (int p = 0; p < 9; p++) {
						if (p != i && p != j) {
							System.out.println(input[p]);
						}
					}
					System.exit(0);
				}

			}
		}

	}

}
