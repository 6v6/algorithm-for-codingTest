package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

//∂±∫∫¿Ã ∂± ∏∏µÈ±‚
public class bs1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ∂±¿« ºˆ
		int m = sc.nextInt(); // ∂±¿« ±Ê¿Ã
		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);

		int start = 0;
		int end = input[n - 1];
		int mid = (start + end) / 2;

		// ¿Ã¡¯≈Ωªˆ
		while (true) {
			int sum = 0;

			if (start >= end)
				break;

			for (int i = 0; i < n; i++) {
				/*
				 * int a = input[i] - mid; if (a < 0) a = 0; sum += a;
				 */
				if (input[i] > mid)
					sum += input[i] - mid;
			}
			if (sum == m) {
				break;
			} else if (sum > m) {
				start = mid;
				mid = (start + end) / 2;
			} else {
				end = mid;
				mid = (start + end) / 2;
			}
		}

		System.out.println(mid);
	}
}
