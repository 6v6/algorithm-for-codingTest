package baekjoon.ch1;

import java.util.Scanner;

public class GCDÇÕ_9613 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int length = sc.nextInt();
    	
    	for(int i = 0; i < length; i++) {
    		int n = sc.nextInt();
    		int[] a = new int[n];
    		for(int j = 0; j < n; j++) {
    			a[j] = sc.nextInt();
    		}
    		
    		long result = 0;
    		for(int p = 0; p < n-1; p++) {
    			for(int q=p+1; q < n; q++) {
    				//result[i] += gcd(a[p], a[q]);
    				result += gcd(a[p], a[q]);
    			}
    		}
    		System.out.println(result);
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
