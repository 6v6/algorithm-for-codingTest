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
		
		//s�� 0�ϰ�� �������� ������ ���ն����� +1�� �ǹǷ� ���� ����
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
		
		//���� ���Ѱ��,
		powerset(arr,  n, idx + 1, s, sum-arr[idx]);
		//���� ���������� ���
		powerset(arr,  n, idx + 1, s, sum);
	}
}
