package baekjoon.ch2.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class ��ȣ�����_1759 {
	public static void make(int p, String[] input, String password, int i) {
		if (password.length() == p) {
			if (check(password)) {
				System.out.println(password);
			}
			return;
		}
		if (i >= input.length)
			return;

		make(p, input, password + input[i], i + 1); // �����ϴ� ���
		make(p, input, password, i + 1); // �������� �ʴ� ���
	}

	// �ּ� �� ���� ����(a, e, i, o, u)�� �ּ� �� ���� ���� üũ
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
		int p = sc.nextInt(); // ��ȣ�� ��
		int q = sc.nextInt(); // ��밡�� ���ĺ� ��
		String input[] = new String[q];
		String password = "";

		for (int i = 0; i < q; i++) {
			input[i] = sc.next();
		}

		Arrays.sort(input);
		make(p, input, password, 0);

	}
}
