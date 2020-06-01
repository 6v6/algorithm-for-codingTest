package baekjoon.ch2;

import java.util.Arrays;
import java.util.Scanner;

public class 차이를최대로_10819 {
	public static boolean next_permutaion(int[] map) {
		
		int i = map.length - 1;
		while(i > 0 && map[i-1] >= map[i])
			i -= 1;
		
		if( i <= 0)
			return false;
		
		int j = map.length - 1;
		
		while(map[j] <= map[i-1])
			j -= 1;
		
		int temp = map[i-1];
		map[i-1] = map[j];
		map[j] = temp;
		
		j = map.length - 1;
		while(i < j) {
			temp = map[i];
			map[i] = map[j];
			map[j] = temp;
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] map = new int[length];
		int sum = 0;
		int result = 0;
		
		for(int i = 0; i < length; i++) {
			map[i] = sc.nextInt();
		}
		Arrays.sort(map);
		do {
			sum = 0;
			for(int i = 2; i <= length; i++) {
				sum = sum + Math.abs((map[i-2] - map[i-1]));
			}
			if(result < sum)
				result  = sum;
		}while(next_permutaion(map));
		
		System.out.println(result);
	}

}
