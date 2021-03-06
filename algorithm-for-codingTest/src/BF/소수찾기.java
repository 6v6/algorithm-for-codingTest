package BF;

import java.util.*;
class Solution2 {
    int answer = 0; 
    private HashSet<String> set = new HashSet<>();
    
    public int solution(String numbers) {
        int n = numbers.length();
        ArrayList<Character> arr = new ArrayList<Character>();  //? ???°ęˇ¨ě ? ??­? ??˝? ?ęľ?
        ArrayList<Character> result = new ArrayList<Character>(); //?şęłí?ŹéŽďż˝ĺ ?ëŞľĺĽ?˝? ç­ëž?˘čŤ??ľ?? ęšě?Şĺ ďż? ? ??­? ??˝
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
            
            //é¤Îťěľďż˝ęś?ś?? ? ??? ?ëľ?
            if(!set.contains(resultString)){
                set.add(resultString);
                //? ?ęşĺ ??ž?ęťě? ??˘
                if(isPrime(Integer.parseInt(resultString)))
                    answer++;
            }
        }
        
        for(int i = 0; i < n; i++){
            result.add(arr.remove(i)); //i?ęłëďż˝ëŽ ?ś?ďż˝ăëą? ďż˝ëďż˝ëć˛â˝??ďż? ? ?ëźĺ ?ë˛?
            permutation(arr, result, n-1, r-1);
            arr.add(i, result.remove(result.size()-1)); //result? ??  ? ??Ť? ?? ?ś?ďż˝ăëą? ďż˝ëďż˝ëć˛â˝??ďż? ? ???°ęˇŁěąˇ?ďż? ? ?ëźĺ ?ëť? ? ?ëźĺ ?ë˛?
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
