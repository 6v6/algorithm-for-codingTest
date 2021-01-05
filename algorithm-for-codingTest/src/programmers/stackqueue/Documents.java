package programmers.stackqueue;
import java.util.*;

//«¡∏∞≈Õ
public class Documents{
    int index;
    int priority;
    
    public Documents(int index, int priority){
        this.index = index;
        this.priority = priority;
    }
}
class Solution {

    public int solution(int[] priorities, int location) {
        Queue<Documents> qu = new LinkedList();
        int count = 0;
        int n = priorities.length;
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            Documents dc = new Documents(i, priorities[i]);
            qu.add(dc);
        }
        
        while(true){
            Documents target = qu.peek();
            count = 0;
            for(Documents dc : qu){
                count++;
                if(target.priority < dc.priority){
                    qu.poll();
                    qu.add(target);
                    break;
                }
            }
            if(count == qu.size()){
                answer++;
                qu.poll();
                if(target.index == location)
                    return answer;
            }
        }
        
       //return answer;
    }
    
    
}
