package baekjoon.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 연산자끼워넣기_14888 {

	public static boolean next_permutation(int[] map) {

		int i = map.length - 1;
		while (i > 0 && map[i - 1] >= map[i])
			i--;

		if (i <= 0)
			return false;

		int j = map.length - 1;
		while (map[j] <= map[i - 1])
			j--;

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
		int n = sc.nextInt(); // 숫자의 수
		int map[] = new int[n]; // 숫자
		int op[] = new int[n - 1]; // 연산자

		for (int i = 0; i < n; i++) {
			map[i] = sc.nextInt();
		}

		int count = 0;
		for (int i = 0; i < 4; i++) {
			int opNumber = sc.nextInt();
			for (int j = 0; j < opNumber; j++) {
				op[count++] = i;
			}
		}

		int max = 0;
		int min = 0;
		int result;
		ArrayList<Integer> al = new ArrayList<Integer>();
		Arrays.sort(op);
		do {
			result = map[0];
			for (int i = 1; i < n; i++) {
				if (op[i - 1] == 0) {
					result = result + map[i];
				} else if (op[i - 1] == 1) {
					result = result - map[i];
				} else if (op[i - 1] == 2) {
					result = result * map[i];
				} else if (op[i - 1] == 3) {
					result = result / map[i];
				}
			}
			al.add(result);
		} while (next_permutation(op));

		int m = al.size();
		Collections.sort(al);
		System.out.println(al.get(m - 1));
		System.out.println(al.get(0));
	}
}
