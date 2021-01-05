package BF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BF4 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		// 알파벳을 담는 리스트
		ArrayList<Character> al = new ArrayList<>();
		// 숫자의 합
		int sum = 0;

		for (int i = 0; i < input.length(); i++) {
			char target = input.charAt(i);
			if (target - '0' >= 0 && target - '0' <= 9)
				sum += target - '0';
			else
				al.add(target);
		}

		Collections.sort(al);

		for (int i = 0; i < al.size(); i++)
			System.out.print(al.get(i));
		System.out.println(sum);

	}
}
