package baekjoon.ch2;

import java.util.Scanner;

public class 테트로미노_14500 {
	
	public static void main(String[] args) {
		
		int[][][] block = {
				{{0,1}, {0,2}, {0,3}}, //1
				{{1,0}, {2,0}, {3,0}}, 
				{{0,1}, {1,0}, {1,1}}, //2
				{{1,0}, {2,0}, {2,1}}, //3
				{{1,0}, {2,0}, {2,-1}},
				{{1,0}, {2,0}, {0,1}},
				{{0,1}, {1,1}, {2,1}},
				{{0,1}, {0,2}, {-1,2}},
				{{1,0}, {0,1}, {0,2}},
				{{0,1}, {0,2}, {1,2}},
				{{1,0}, {1,1}, {1,2}},
				{{0,1}, {0,2}, {1,1}}, //4
				{{1,0}, {2,0}, {1,1}},
				{{0,1}, {0,2}, {-1,1}},
				{{1,0}, {2,0}, {1,-1}},
				{{1,0}, {1,1}, {2,1}},//5
				{{1,0}, {1,-1}, {2,-1}},
				{{0,1}, {1,1}, {1,2}},
				{{0,1}, {-1,1}, {-1,2}}
		};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] map = new int[n][m]; // 세로 가로
		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 19; k++) {
					boolean check = true;
					int sum = map[i][j];
					for (int l = 0; l < 3; l++) {
						int y = i + block[k][l][0];
						int x = j + block[k][l][1];
						if (x >= 0 && x < m && y >= 0 && y < n) {
							sum += map[y][x];
						} else {
							check = false;
							break;
						}
					}
					if (check && result < sum) {
						result = sum;
					}
				}
			}
		}
		System.out.println(result);
	}

}
