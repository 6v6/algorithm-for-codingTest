package programmers.¿ÏÀüÅ½»ö;

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int sum1, sum2, sum3, max;

        ArrayList<Integer> al = new ArrayList<Integer>();

        sum1 = 0;
        sum2 = 0;
        sum3 = 0;

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[i%a.length])
                sum1++;
            if(answers[i] == b[i%b.length])
                sum2++;
            if(answers[i] == c[i%c.length])
                sum3++;

        }

        max = 0;
        if(sum1 > sum2){
            if(sum1 > sum3){
                al.add(1);
            }
            else if(sum1 < sum3){
                 al.add(3);
            }
            else{
                 al.add(1);
                 al.add(3);
            }
        }
        else if(sum1 < sum2){
            if(sum2 > sum3){
                al.add(2);
            }
            else if(sum2 < sum3){
                al.add(3);
            }public class ëª¨ì˜ê³ ì‚¬ {
                
            }
            else{
                al.add(2);
                al.add(3);
            }
        }
        else{
            if(sum1>sum3){
                al.add(1);
                al.add(2);
            }
            else if(sum1 < sum3){
                al.add(3);
            }
            else{
                al.add(1);
                al.add(2);
                al.add(3);
            }
        }

        answer = new int[al.size()];
        for(int i = 0; i<al.size(); i++){
            answer[i] = al.get(i);
            System.out.println(al.get(i));
        }
        return answer;
    }
}