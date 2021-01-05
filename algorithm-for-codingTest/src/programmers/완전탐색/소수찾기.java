package programmers.완전탐색;
import java.util.*;
class Solution2 {
    int answer = 0; 
    private HashSet<String> set = new HashSet<>();
    
    public int solution(String numbers) {
        int n = numbers.length();
        ArrayList<Character> arr = new ArrayList<Character>();  //�썝蹂� �닽�옄�뱾
        ArrayList<Character> result = new ArrayList<Character>(); //議고빀�쑝濡� 留뚮뱾�뼱吏� �닽�옄
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
            
            //以묐났媛� �솗�씤
            if(!set.contains(resultString)){
                set.add(resultString);
                //�냼�닔寃��궗
                if(isPrime(Integer.parseInt(resultString)))
                    answer++;
            }
        }
        
        for(int i = 0; i < n; i++){
            result.add(arr.remove(i)); //i踰덉㎏ 媛믪쓣 爰쇰궡�꽌 �떞�쓬
            permutation(arr, result, n-1, r-1);
            arr.add(i, result.remove(result.size()-1)); //result�뿉 �꽔�� 媛믪쓣 爰쇰궡�꽌 �썝蹂몄뿉 �떎�떆 �떞�쓬
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
