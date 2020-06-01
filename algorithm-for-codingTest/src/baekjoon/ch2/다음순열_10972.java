package baekjoon.ch2;

import java.util.Scanner;

public class 다음순열_10972 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int map[] = new int[size];
		int i;

		// 주어진 순열 담기
		for (i = 0; i < size; i++) {
			map[i] = sc.nextInt();
		}

		i = size - 1;
		while (i > 0 && map[i - 1] >= map[i])
			i -= 1;

		if (i <= 0) {
			System.out.println(-1);
			return;
		}

		int j = size - 1;
		while (map[j] <= map[i - 1])
			j -= 1;

		int temp = map[i - 1];
		map[i - 1] = map[j];
		map[j] = temp;

		j = size - 1;
		while (i < j) {
			temp = map[i];
			map[i] = map[j];
			map[j] = temp;
			i++;
			j--;
		}

		for (i = 0; i < size; i++) {
			System.out.print(map[i] + " ");
		}
	}
}
