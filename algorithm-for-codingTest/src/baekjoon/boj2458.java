package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class boj2458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] graph = new int[n][n];
		int result = 0; 
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) graph[i][j] = 0;
				else graph[i][j] = (int)1e9;
			}
		}
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			graph[x][y] = -1;
			graph[y][x] = 1;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(graph[i][j] == (int)1e9) {
						if(graph[i][k] == 1 && graph[k][j] == 1)
							graph[i][j] = 1;
						if(graph[i][k] == -1 && graph[k][j] == -1)
							graph[i][j] = -1;
					}
				}
			}
		}
		

		
		for(int i = 0; i < n; i++) {
			int count = 0;
			for(int j = 0; j < n; j++) {
				if(graph[i][j] == (int)1e9) count++;
			}
			if(count == 0)
				result++;
		}
		
		System.out.println(result);
	}
}
