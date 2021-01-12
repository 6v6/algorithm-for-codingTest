package DP;

import java.util.Scanner;

//1로 만들기
public class dp2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] d = new int[30001];

		for (int i = 2; i <= x; i++) {
			// 1을 빼는 경우
			d[i] = d[i - 1] + 1;
			if (i % 5 == 0)
				d[i] = Math.min(d[i], d[i / 5] + 1);
			if (i % 3 == 0)
				d[i] = Math.min(d[i], d[i / 3] + 1);
			if (i % 2 == 0)
				d[i] = Math.min(d[i], d[i / 2] + 1);
		}

		System.out.println(d[x]);
	}
}
