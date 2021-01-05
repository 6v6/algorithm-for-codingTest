package baekjoon.step;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class boj1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Double> al = new ArrayList<Double>();
        for(int i = 0; i < n; i++){
            al.add(sc.nextDouble());
        }

        Collections.sort(al);
        double max = al.get(al.size()-1);
        double sum = 0;

        for(int i = 0; i <n; i++){
            // /�젏�닔/M*100
            double newNum = al.get(i)/max*100;
            sum += newNum;
        }

        System.out.println(sum/n);
        
    }
}
