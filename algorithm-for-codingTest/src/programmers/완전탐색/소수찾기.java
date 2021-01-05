import java.util.*;
class Solution {
    int answer = 0; 
    private HashSet<String> set = new HashSet<>();
    
    public int solution(String numbers) {
        int n = numbers.length();
        ArrayList<Character> arr = new ArrayList<Character>();  //원본 숫자들
        ArrayList<Character> result = new ArrayList<Character>(); //조합으로 만들어진 숫자
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
            
            //중복값 확인
            if(!set.contains(resultString)){
                set.add(resultString);
                //소수검사
                if(isPrime(Integer.parseInt(resultString)))
                    answer++;
            }
        }
        
        for(int i = 0; i < n; i++){
            result.add(arr.remove(i)); //i번째 값을 꺼내서 담음
            permutation(arr, result, n-1, r-1);
            arr.add(i, result.remove(result.size()-1)); //result에 넣은 값을 꺼내서 원본에 다시 담음
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
