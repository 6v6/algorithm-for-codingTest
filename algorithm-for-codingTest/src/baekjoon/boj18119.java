package baekjoon;

import java.util.Scanner;

//�ܾ� �ϱ�
public class boj18119 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//���ڿ��� ��
		int n = sc.nextInt();
		//���� �� ��
		int m = sc.nextInt();
		
		//1�� �ʱ�ȭ�� 26�ڸ� ��Ʈ
		int alph = (1 << 27) - 1;
		
		//�ܾ ��� �迭
		int[] words = new int[n];
		
		for(int i = 0; i < n; i++) {
			String word = sc.next();
			// ���ܾ��� ���ĺ� ��ġ�� 1�� ����
			for(char c : word.toCharArray())
				words[i] |= 1 << (c -'a');
		}
		
		for(int i = 0; i < m; i++) {
			int o = sc.nextInt();
			char target = sc.next().charAt(0);
			
			//�ش´�
			if(o == 1) {
				//target��ġ�� ���� 0���� �ٲٰ� & �����ڸ� ���� �� �κ��� alph��Ʈ ���� 0���� ����
				alph &= ~(1 << (target-'a')); 
			}
			//����Ѵ�
			else {
				alph |= (1 << (target-'a')); 
			}
			
			int count = 0;
			for(int j = 0; j < words.length; j++) {
				//alph�� word������ ���� word���� ���ų� ũ�� ��� �˹����� �˰� �ִ� ������ �ܾ �ƴ� ��.
				if((alph & words[j]) >= words[j]) {
					count++;
				}
			}
			System.out.println(count);
			
		}
	}
}
