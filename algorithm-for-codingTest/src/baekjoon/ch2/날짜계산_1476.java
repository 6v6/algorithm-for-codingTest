package baekjoon.ch2;

import java.util.Scanner;

public class 날짜계산_1476 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt(); // 15
		int S = sc.nextInt(); // 28
		int M = sc.nextInt(); // 19

		for (int i = 0;; i++) {
			if (i % 15 == E && i % 28 == S && i % 19 == M) {
				System.out.println(i + 1);
				break;
			}
		}
	}



/*	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt(); // 15
		int S = sc.nextInt(); // 28
		int M = sc.nextInt(); // 19

		int e = 1;
		int s = 1;
		int m = 1;

		for (int i = 0;; i++) {
			if (e == E && s == S && m == M) {
				System.out.println(i);
				break;
			} else {
				e++;
				s++;
				m++;
				if (e == 16)
					e = 1;
				if (s == 29)
					s = 1;
				if (m == 20)
					m = 1;
			}
		}
	}*/

}
