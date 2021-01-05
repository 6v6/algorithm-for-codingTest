package BF;

import java.util.*;
class Solution2 {
    int answer = 0; 
    private HashSet<String> set = new HashSet<>();
    
    public int solution(String numbers) {
        int n = numbers.length();
        ArrayList<Character> arr = new ArrayList<Character>();  //?��?��?��?��귨옙 ?��?��?��?��?��?��?��?���?
        ArrayList<Character> result = new ArrayList<Character>(); //?��곌�?�鍮�占?��몵嚥?��?�� 筌띾?���??��?��?��깍�?�占�? ?��?��?��?��?��?��
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
            
            //餓λ쵎�궗?��?��?�� ?��?��?��?��?���?
            if(!set.contains(resultString)){
                set.add(resultString);
                //?��?��꺖占?��?��?��껓옙?��?��?��
                if(isPrime(Integer.parseInt(resultString)))
                    answer++;
            }
        }
        
        for(int i = 0; i < n; i++){
            result.add(arr.remove(i)); //i?��곕뜆�럮 ?��?���れ�? �댆�눖沅∽?��?���? ?��?��뼖占?���?
            permutation(arr, result, n-1, r-1);
            arr.add(i, result.remove(result.size()-1)); //result?��?��?�� ?��?��?��?��?��?�� ?��?���れ�? �댆�눖沅∽?��?���? ?��?��?��?��귣챷?���? ?��?��뼄占?���? ?��?��뼖占?���?
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
