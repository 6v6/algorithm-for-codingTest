package baekjoon;

import java.util.Scanner;

public class boj1182 {

	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		powerset(arr, n, 0, s, 0);
		
		//s가 0일경우 공집합인 순열의 조합때문에 +1이 되므로 값을 빼줌
		if(s == 0)
			result--;
		
		System.out.println(result);
	}

	private static void powerset(int[] arr, int n, int idx, int s, int sum) {
		
		if (idx == n) {
			if(sum == s)
				result++;
			return;
		}
		
		sum = sum+arr[idx];
		
		//값을 더한경우,
		powerset(arr,  n, idx + 1, s, sum-arr[idx]);
		//값을 더하지않은 경우
		powerset(arr,  n, idx + 1, s, sum);
	}
}
