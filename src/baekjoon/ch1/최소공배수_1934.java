package baekjoon.ch1;

import java.util.Scanner;

public class 최소공배수_1934 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int length = sc.nextInt();
    	
    	for(int i = 0; i < length; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		System.out.println(a*b/gcd(a,b)); //최소공배수 : a*b/gcd
    	}

    }
    
    public static int gcd(int a, int b) {
    	while(b != 0) {
    		int r = a % b;
    		a = b;
    		b = r;
    	}
    	return a;
    }
}
