package baekjoon.ch2;

import java.util.Scanner;

public class ·Î¶Ç_6603 {

	public static boolean next_permutation(int[] map) {

		int i = map.length - 1;
		while (i > 0 && map[i - 1] >= map[i]) {
			i--;
		}

		if (i <= 0)
			return false;

		int j = map.length - 1;
		while (map[j] <= map[i - 1]) {
			j--;
		}

		int temp = map[i - 1];
		map[i - 1] = map[j];
		map[j] = temp;

		j = map.length - 1;
		while (i < j) {
			temp = map[i];
			map[i] = map[j];
			map[j] = temp;

			i++;
			j--;
		}

		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] map;
		int[] check;
		while (k != 0) {
			map = new int[k];
			check = new int[k];
			for (int i = 0; i < k; i++) {
				map[i] = sc.nextInt();
				if (i >= 6)
					check[i] = 1;
				else
					check[i] = 0;
			}

			do {
				for (int i = 0; i < check.length; i++) {
					if (check[i] == 0)
						System.out.print(map[i] + " ");
				}
				System.out.println("");
			} while (next_permutation(check));
			System.out.println(" ");
			k = sc.nextInt();
		}
	}
}
