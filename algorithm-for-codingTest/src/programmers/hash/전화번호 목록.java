import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

       for(String p1 : phone_book){  
           for(String p2 : phone_book){
               if(p1.length() <= p2.length() && !p1.equals(p2)){
                   if(p1.equals(p2.substring(0,p1.length()))){
                       return false;
                   }
               }
           }
        }
        return answer;
    }
}