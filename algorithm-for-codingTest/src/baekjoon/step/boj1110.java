package baekjoon.step;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number = n;
        int ten, one; // 10�쓽�옄由�, 1�쓽�옄由�
        int newNum;
        int count = 0;

        while (true) {
            count++;
            if (number < 10) {
                ten = 0;
                one = number;
            } else {
                ten = number / 10;
                one = number % 10;
            }

            newNum = one * 10 + (ten + one) % 10;

            if (newNum == n) {
                System.out.println(count);
                break;
            }
            number = newNum;
        }
    }
}
