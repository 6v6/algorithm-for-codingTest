package programmers.stackqueue;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ansList = new ArrayList<>();
        Queue<Integer> period = new LinkedList<Integer>();
    
        for(int i = 0; i < progresses.length; i++){
            if ((100-progresses[i]) % speeds[i] == 0)
                period.add((100-progresses[i]) / speeds[i]);
            else
                period.add((100-progresses[i]) / speeds[i] +1);
        }
        
        int count = 1;
        int status;
        
        while(!period.isEmpty()){
            count = 1;
            status = period.poll();
            while(!period.isEmpty() && status>=period.peek()){
                count++;
                period.poll();
            }
            ansList.add(count);
        }
        
        int[] answer = new int[ansList.size()];
        System.out.println(ansList.size());
        for(int i = 0; i < ansList.size(); i++){
            answer[i]=ansList.get(i);
        }
        return answer;
    }
}