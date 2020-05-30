package baekjoon.ch1;

import java.util.Scanner;

public class 최대공약수와최소공배수_2609 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int result1 = gcd(a,b);
		int result2 = (a*b)/result1;
		
		System.out.println(result1);
		System.out.println(result2);
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	

}
