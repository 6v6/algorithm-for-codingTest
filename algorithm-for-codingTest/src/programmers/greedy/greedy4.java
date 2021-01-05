package programmers.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//모험가 길드
public class greedy4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		int result = 0;

		for (int i = 0; i < n; i++) {
			al.add(sc.nextInt());
		}

		Collections.sort(al);

		int num = 0;
		for (int i = 0; i < n; i++) {
			int x = al.get(i);
			num++;
			if (x <= num) {
				result++;
				num = 0;
			}
		}

		System.out.println(result);
	}
}
