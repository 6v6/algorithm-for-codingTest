package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class boj1062 {
	static HashSet<Integer> hs = new HashSet<>();
	static int max = 0;
	static boolean[] alphabet;
	static String[] words;
	static int[] candi;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		alphabet = new boolean[26];

		int n = sc.nextInt();
		int k = sc.nextInt();
		words = new String[n];

		if (k < 5) {
			System.out.println(0);
			return;
		}

		alphabet['a' - 'a'] = true;
		alphabet['n' - 'a'] = true;
		alphabet['t' - 'a'] = true;
		alphabet['i' - 'a'] = true;
		alphabet['c' - 'a'] = true;

		k -= 5;

		for (int i = 0; i < n; i++) {
			words[i] = sc.next();
			for (int j = 0; j < words[i].length(); j++) {
				if (!alphabet[words[i].charAt(j) - 'a']) {
					hs.add(words[i].charAt(j) - 'a');
				}
			}
		}

		boolean[] visit = new boolean[hs.size()];
		candi = new int[hs.size()];
		int index = 0;

		for (int a : hs) {
			candi[index] = a;
			index++;
		}

		if (hs.size() < k)
			k = hs.size();
		comb(0, visit, hs.size(), k);

		System.out.println(max);
	}

	private static void comb(int start, boolean[] visit, int n, int k) {
		if (k == 0) {
			for (int i = 0; i < visit.length; i++) {
				if (visit[i]) {
					// System.out.print(i);
					alphabet[candi[i]] = true;
					// System.out.println(candi[i]);
				}
			}

			// ���� �� �ִ� �ܾ��� �� Ȯ��
			int check = 0;
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words[i].length(); j++) {
					if (!alphabet[words[i].charAt(j) - 'a']) {
						break;
					}
					if (j == words[i].length() - 1)
						check++;
				}
			}

			max = Math.max(max, check);

			for (int i = 0; i < visit.length; i++) {
				if (visit[i]) {
					alphabet[candi[i]] = false;
				}
			}

			return;
		}

		for (int i = start; i < n; i++) {
			visit[i] = true;
			comb(i + 1, visit, n, k - 1);
			visit[i] = false;
		}
	}
}
