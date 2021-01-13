package DP;

import java.util.Arrays;
import java.util.Scanner;

//瓤啦利牢 拳企 备己
public class dp3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] input = new int[n];
		int[] d = new int[10001];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.fill(d, 10001);
		d[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = input[i]; j <= m; j++) {
				if (d[j - input[i]] != 10001) {
					d[j] = Math.min(d[j], d[j - input[i]] + 1);
				}
			}
		}
		
		if(d[m] == 10001) System.out.println("-1");
		else System.out.println(d[m]);
	}
}
