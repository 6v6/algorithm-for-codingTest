package baekjoon.step;

import java.util.Scanner;

class boj2884 {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int ch = h;
        int cm = m;

        if (m - 45 < 0) {
            if (h == 0) {
                ch = 23;
            } else {
                ch--;
            }
            cm = 60 - Math.abs(m - 45);
        } else {
            cm = m - 45;
        }

        System.out.println(ch + " " + cm);
    }
}
