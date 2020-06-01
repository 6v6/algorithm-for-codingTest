package baekjoon.ch2;

import java.util.Scanner;

public class 모든순열_10974 {

	public static boolean next_permutation(int[] map) {

		int i = map.length - 1;

		while (i > 0 && map[i - 1] >= map[i])
			i -= 1;

		if (i <= 0) {
			return false;
		}

		int j = map.length - 1;
		while (map[j] <= map[i - 1])
			j -= 1;

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
		int size = sc.nextInt();
		int map[] = new int[size];
		int i;

		// 순열 생성
		for (i = 0; i < size; i++) {
			map[i] = i + 1;
		}

		do {
			for (i = 0; i < size; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println("");
		} while (next_permutation(map));

	}

}
