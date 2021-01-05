package programmers.dfsbfs;

import java.util.*;
class Solution3 {
    ArrayList<String> answerList = new ArrayList<String>();
    boolean[] visit;
    
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        String[] answer = new String[tickets.length+1];
        String route = "";
        
    
        dfs("ICN", tickets, route, 0); 
        
        Collections.sort(answerList);
        answer = answerList.get(0).split(",");
        return answer;
    }
    
    public void dfs(String a, String[][] tickets, String route, int node){
        
         route += a + ",";
        
        if(node == tickets.length){
            answerList.add(route);
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(a.equals(tickets[i][0]) && !visit[i]){
                visit[i] = true;
                dfs(tickets[i][1],tickets, route, node+1);
                visit[i] = false;
            }
        }
    }
}
