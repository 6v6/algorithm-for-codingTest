package baekjoon.ch1;

import java.util.Scanner;

public class 소수구하기_1929 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		for(int i = start; i <= end; i++) {
			if(prime(i))
				System.out.println(i);
		}
		

	}

	public static boolean prime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
