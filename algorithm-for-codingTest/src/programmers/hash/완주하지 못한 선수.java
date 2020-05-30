import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hash = new HashMap<>();
        int val = 0;
        for(String par : participant){
            if(hash.get(par)==null)
                hash.put(par,1);
            else{
                val = hash.get(par) + 1;
                hash.put(par, val);           
            }
        }
        
        for(String com : completion){
            if(hash.get(com)!=0){
                val = hash.get(com) - 1;
                hash.put(com, val);
            }          
        }
        
        for(String par : participant){
            if(hash.get(par)==1){
                answer = par;
            }          
        }
        
        return answer;
    }
}