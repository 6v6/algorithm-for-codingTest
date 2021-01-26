package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj1644 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int max = n;
		boolean[] arr = new boolean[max + 1];
		int count = 0;

		if (n < 2) {
			System.out.println(0);
			return;
		}
		Arrays.fill(arr, true);
		// �Ҽ�����Ʈ
		ArrayList<Integer> primeList = new ArrayList<>();
		// �κ��� ����Ʈ
		ArrayList<Integer> sumList = new ArrayList<>();

		// �Ҽ� ���ϱ� - �����佺�׳׽��� ü
		for (int i = 2; i <= Math.sqrt(max); i++) {
			if (arr[i]) {
				int j = 2;
				while (i * j <= max) {
					arr[i * j] = false;
					j++;
				}
			}
		}

		int sum = 0;
		for (int i = 2; i <= max; i++) {
			// �Ҽ� ���
			if (arr[i]) {
				primeList.add(i);
				sum += i;
				sumList.add(sum);
				if (sum == n)
					count++;
			}
		}

		int start = 0;
		int end = 0;
		while (sumList.get(end) < n)
			end++;

		while (end < sumList.size()) {
			if (sumList.get(end) - sumList.get(start) == n)
				count++;

			if (sumList.get(end) - sumList.get(start) <= n) {
				end++;
			}

			start++;

		}

		System.out.println(count);
	}
}
