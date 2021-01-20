package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//����
public class boj2437 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		// ������������ ����
		Arrays.sort(input);

		// ���� ���� ���� ���� 1�� �ƴѰ��
		if (input[0] != 1) {
			System.out.println(1);
			return;
		}

		// �������� ��� ����
		int sum = input[0];
		for (int i = 1; i < n; i++) {
			if (sum + 1 < input[i]) {
				answer = sum + 1;
				break;
			}
			sum += input[i];
		}

		//��� ������ �� �� ������ ���� �� �ִ� ���
		if (answer == 0)
			answer = sum + 1;

		System.out.println(answer);

	}
}
