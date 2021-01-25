package baekjoon;

import java.util.Scanner;

//단어 암기
public class boj18119 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//문자열의 수
		int n = sc.nextInt();
		//쿼리 의 수
		int m = sc.nextInt();
		
		//1로 초기화된 26자리 비트
		int alph = (1 << 27) - 1;
		
		//단어를 담는 배열
		int[] words = new int[n];
		
		for(int i = 0; i < n; i++) {
			String word = sc.next();
			// 각단어의 알파벳 위치만 1로 변경
			for(char c : word.toCharArray())
				words[i] |= 1 << (c -'a');
		}
		
		for(int i = 0; i < m; i++) {
			int o = sc.nextInt();
			char target = sc.next().charAt(0);
			
			//잊는다
			if(o == 1) {
				//target위치의 값만 0으로 바꾸고 & 연산자를 통해 그 부분의 alph비트 값을 0으로 변경
				alph &= ~(1 << (target-'a')); 
			}
			//기억한다
			else {
				alph |= (1 << (target-'a')); 
			}
			
			int count = 0;
			for(int j = 0; j < words.length; j++) {
				//alph와 word연산한 값이 word보다 같거나 크면 모든 알바펫을 알고 있는 것으로 단어를 아는 것.
				if((alph & words[j]) >= words[j]) {
					count++;
				}
			}
			System.out.println(count);
			
		}
	}
}
