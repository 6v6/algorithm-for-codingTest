package baekjoon.ch2.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기_1759 {
	public static void make(int p, String[] input, String password, int i) {
		if (password.length() == p) {
			if (check(password)) {
				System.out.println(password);
			}
			return;
		}
		if (i >= input.length)
			return;

		make(p, input, password + input[i], i + 1); // 선택하는 경우
		make(p, input, password, i + 1); // 선택하지 않는 경우
	}

	// 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음 체크
	public static boolean check(String password) {

		int check_mo = 0;
		int check_ja = 0;
		for (char x : password.toCharArray()) {
			if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') // , e, i, o, u
				check_mo++;
			else
				check_ja++;
		}
		return check_mo >= 1 && check_ja >= 2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt(); // 암호의 수
		int q = sc.nextInt(); // 사용가능 알파벳 수
		String input[] = new String[q];
		String password = "";

		for (int i = 0; i < q; i++) {
			input[i] = sc.next();
		}

		Arrays.sort(input);
		make(p, input, password, 0);

	}
}
