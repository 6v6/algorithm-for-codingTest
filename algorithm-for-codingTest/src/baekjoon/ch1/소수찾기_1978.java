package baekjoon.ch1;

import java.util.Scanner;

public class 소수찾기_1978 {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int count = 0;
		for(int i = 0; i < length; i++) {
			int n = sc.nextInt();
			if(prime(n))
				count++;
		}
		System.out.println(count);

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
