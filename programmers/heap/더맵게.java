import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        int r1, r2,temp;
        int time = 0;
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.size()>1){
            if(pq.peek()>=K)
                break;
            
            r1 = pq.poll();
            r2 = pq.poll();
            
            time++;
            temp = r1 +r2*2;
            pq.add(temp);
            
        }
        
        if(pq.poll() >= K)
            answer = time;
        
        return answer;
    }
}