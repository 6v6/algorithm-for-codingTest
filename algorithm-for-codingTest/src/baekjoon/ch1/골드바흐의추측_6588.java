package baekjoon.ch1;

import java.util.Scanner;

public class ∞ÒµÂπŸ»Â¿«√ﬂ√¯_6588 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int target = 1;
		int temp = 0;
		int i;
		boolean isSuccess = false;

		int[] prime = new int[1000000];
		int pn = 0;
		boolean check[] = new boolean[1000000];
		int n = 1000000;

		for (i = 2; i < n; i++) {
			if (check[i] == false) {
				prime[pn++] = i;
				for (int j = i + i; j < n; j += i) {
					check[j] = true;
				}
			}
		}

		while (true) {
			target = sc.nextInt();

			if (target == 0)
				break;

			for (i = 3; i < n / 2; i++) {
				temp = target - i;
				if (!check[temp] && !check[i]) {
					System.out.println(target + " = " + i + " + " + temp);
					isSuccess = true;
					break;
				}
			}
			if (!isSuccess)
				System.out.println("Goldbach's conjecture is wrong.");
		}

	}
}
