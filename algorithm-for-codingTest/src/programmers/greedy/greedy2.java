package programmers.greedy;

import java.util.Scanner;

//1�� �� ������
public class greedy2 {
	// N���� 1����
	// N�� K�� ������
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("����");
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;

		while (true) {
			int temp = (n / k) * k;
			result += n - temp;
			n = temp;
			if (n < k)
				break;
			result++;
			n = n / k;
		}

		result += n - 1;
		System.out.println(result);
	}
}
