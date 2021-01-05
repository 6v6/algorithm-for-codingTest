package programmers.stackqueue;

import java.util.*;
class Solution1 {
    public int[] solution(int[] heights) {
        int total = heights.length;
        int[] answer = new int[total];
        Stack<Integer> st = new Stack<Integer>();
        int send, receive;
        int num;
        
        if(st.empty()){
            System.out.println("鍮꾩뿀�쓬");
        }
        
        for(int i = 0; i < total; i++){
            st.push(heights[i]);
        }
        for(int i = total-1; i >=0; i--){
            send = st.pop();
            num = 0;
            while(!st.empty()){
                receive = st.pop();
                num++;
                if(send < receive){
                    answer[i] = i-num+1;
                    break;
                }
            }
            for(int j = i - num; j < i; j++){
                st.push(heights[j]);
            }
        }

        return answer;
    }
}