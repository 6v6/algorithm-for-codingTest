package BF;

import java.util.*;
class Solution2 {
    int answer = 0; 
    private HashSet<String> set = new HashSet<>();
    
    public int solution(String numbers) {
        int n = numbers.length();
        ArrayList<Character> arr = new ArrayList<Character>();  //? ?Œ?œš?™°ê·¨ì˜™ ? ?ˆ?–­? ?Œ?½? ?ˆêµ?
        ArrayList<Character> result = new ArrayList<Character>(); //?ˆºê³Œí?¬é®ï¿½å ?Œëªµåš¥?ˆ½?˜™ ç­Œë¾?Š¢è«??–µ?˜™? ‰ê¹ì?ªå ï¿? ? ?ˆ?–­? ?Œ?½
        for(int i = 0; i < numbers.length(); i++){
            arr.add(numbers.charAt(i));
        }
        
        for(int i = 0; i < n; i++){
            permutation(arr, result, n, i+1);
        }
        
        return answer;
    }
    
    public void permutation(List<Character> arr, List<Character> result, int n, int r ){
        
        String resultString = "";
        
        if(r == 0 && result.get(0) != '0' ){
            for(int i = 0; i < result.size(); i++){
                resultString += result.get(i);   
            }
            
            //é¤“Î»ìµï¿½ê¶—?¶?‰?˜™ ? ?Œ?„‡? ?Œëµ?
            if(!set.contains(resultString)){
                set.add(resultString);
                //? ?ˆêº–å ?ˆ?•¾?‡ê»“ì˜™? ?„?…¢
                if(isPrime(Integer.parseInt(resultString)))
                    answer++;
            }
        }
        
        for(int i = 0; i < n; i++){
            result.add(arr.remove(i)); //i?”•ê³•ëœ†ï¿½ëŸ® ?¶?…ï¿½ã‚Œë±? ï¿½ëŒ†ï¿½ëˆ–æ²…âˆ½?˜™?‹‘ï¿? ? ?ˆë¼–å ?Œë²?
            permutation(arr, result, n-1, r-1);
            arr.add(i, result.remove(result.size()-1)); //result? ?ˆ?“  ? ?„?«? ?™?˜™ ?¶?…ï¿½ã‚Œë±? ï¿½ëŒ†ï¿½ëˆ–æ²…âˆ½?˜™?‹‘ï¿? ? ?Œ?œš?™°ê·£ì±·?‚‰ï¿? ? ?ˆë¼„å ?ˆë»? ? ?ˆë¼–å ?Œë²?
        }
    }
    
    public boolean isPrime(int n){
        if( n < 2)
            return false;
        for(int i = 2; i*i <= n; i++ ){
            if( n % i == 0)
                return false;
        }
        return true;
    }
}
