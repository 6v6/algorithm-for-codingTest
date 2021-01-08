package BinarySearch;

import java.util.Scanner;

//���ĵ� �迭���� Ư�� ���� ���� ���ϱ�
public class bs2 {

	public static int bs(int[] input, int s, int e, int x) {
		int mid = (s + e) / 2;
		while (true) {
			mid = (s + e) / 2;
			if (s >= e) {
				mid = -1;
				break;
			}
			if (input[mid] == x) {
				break;
			}
			// ã�� ������ ũ��
			if (input[mid] > x) {
				e = mid;
				mid = (s + e) / 2;
			} else if (input[mid] < x) {
				s = mid;
				mid = (s + e) / 2;
			}
		}

		return mid;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] input = new int[n];
		int result = -1;

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		int start = 0;
		int end = n - 1;
		
		if(input[n-1] < x) {
			System.out.println(-1);
			return;
		}
		
		int mid = bs(input, start, end, x);
		int si = 0;
		int ei = 0;
/*
7 2
1 1 2 2 2 2 3
*/
		if (mid != -1) {
			while (true) {
				// ó�� �ε��� ã��
				if (input[mid] == x) {
					if (input[mid - 1] == x) {
						mid = bs(input, start, mid, x);
					} else {
						si = mid;
						break;
					}
				}
			}
			
			while (true) {
				if (input[mid] == x) {
					if (input[mid + 1] == x) {
						mid = bs(input, mid, end, x);
					} else {
						ei = mid;
						break;
					}
				}
			}
		}

		if (ei > si) {
			result = ei - si + 1;
		} else {
			result = -1;
		}
		// ������ �ε��� ã��
		System.out.println(result);
		return;
	}

}
