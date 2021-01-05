package BF;

import java.util.Scanner;

//�ս��� ����Ʈ
public class BF3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String location = sc.next();
		int x = location.charAt(0) - 'a';
		int y = location.charAt(1) - '1';
		int result = 0;

		// �� �� �� �� X �� ��
		int[] dx = { 2, 2, -2, -2, 1, -1, 1, -1 };
		int[] dy = { -1, 1, -1, 1, -2, -2, 2, 2 };

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8)
				result++;
		}

		System.out.println(result);
	}
}
