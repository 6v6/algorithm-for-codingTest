import java.util.*;
class Solution {
    
    int answer = 50;
    public int solution(String begin, String target, String[] words) {
     
        ArrayList<String> wordsList = new ArrayList<String>();
        
        for(int i = 0; i < words.length; i++){
            wordsList.add(words[i]);
        }
        
        //words에  target이 없으면 0을 return;
        if(!wordsList.contains(target))
            return 0;
        
        //dfs 시작
        dfs(begin, target, wordsList, 0);

        return answer;
    }
    
    // 알파벳이 하나만 차이 나는지 확인
    public boolean differentCheck(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        if(count == 1)
            return true;
        return false;
    }
    
    public void dfs(String select, String target, ArrayList<String> words, int count){
        if(select.equals(target)){
            if(answer > count)
                answer = count;
        }
        
        for(int i = 0; i < words.size(); i++){
            if(differentCheck(select, words.get(i))){
                String temp = words.get(i);
                words.remove(words.get(i));
                dfs(temp, target, words, count+1);
                words.add(i, temp);
            }
        }
        
    }
}
