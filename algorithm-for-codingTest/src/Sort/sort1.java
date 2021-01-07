package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class sort1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}

		Arrays.sort(a);
		Arrays.sort(b);

		int i = 0;
		while (k != 0) {
			if (a[i] < b[n - (i + 1)]) {
				a[i] = b[n - (i + 1)];
				k--;
			}
			i++;
		}

		int sum = 0;
		for (int j : a) {
			sum += j;
		}

		System.out.println(sum);

	}

}
