package programmers.����Ž��;

import java.util.Scanner;

//�����¿� ����
public class BF1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// N�� �Է¹ޱ�
		int n = sc.nextInt();
		sc.nextLine(); // ���� ����
		String[] plans = sc.nextLine().split(" ");
		int x = 1, y = 1;

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		String[] type = { "L", "R", "U", "D" };

		for (int i = 0; i < plans.length; i++) {
			for (int j = 0; j < 4; j++) {
				if (plans[i].equals(type[j])) {
					int nextX = x + dx[j];
					int nextY = y + dy[j];
					if (nextX >= 1 && nextX <= n)
						x = nextX;
					if (nextY >= 1 && nextY <= n)
						y = nextY;
				}
			}
		}

		System.out.println(x + " " + y);
	}
}
