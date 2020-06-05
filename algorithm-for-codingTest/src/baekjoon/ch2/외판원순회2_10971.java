package baekjoon.ch2;

import java.util.Scanner;

public class 외판원순회2_10971 {

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
		int n = sc.nextInt();
		int[][] w = new int[n][n];
		int[] d = new int[n];

		boolean ok = true;
		int sum = 0;
		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				w[i][j] = sc.nextInt();
			}
			d[i] = i;
		}

		do {
			sum = 0;
			ok = true;
			if(d[0] != 0)
				break;
			for (int i = 0; i < n - 1; i++) {
				if (w[d[i]][d[i + 1]] == 0) {
					ok = false;
				} else {
					sum += w[d[i]][d[i + 1]];
				}
			}
			if (ok && w[d[n - 1]][d[0]] != 0) {
				sum += w[d[n - 1]][d[0]];
				if (sum < result || result == 0)
					result = sum;
			}
		} while (next_permutation(d));
		
		System.out.println(result);
	}

}
