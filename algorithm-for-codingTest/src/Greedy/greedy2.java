package Greedy;

import java.util.Scanner;

//1이 될 때까지
public class greedy2 {
	// N에서 1빼기
	// N을 K로 나누기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("시작");
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
