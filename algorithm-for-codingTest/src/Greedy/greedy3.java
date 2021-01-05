package Greedy;

import java.util.Scanner;

//곱하기 혹은 더하기
public class greedy3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int result = str.charAt(0) - '0';
		for (int i = 1; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			if (num < 2 || result < 2)
				result = result + num;
			else
				result = result * num;
		}

		System.out.println(result);
	}
}
