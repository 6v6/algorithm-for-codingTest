package programmers.dfsbfs;

import java.util.*;

class Solution2 {
    
    int answer = 50;
    public int solution(String begin, String target, String[] words) {
     
        ArrayList<String> wordsList = new ArrayList<String>();
        
        for(int i = 0; i < words.length; i++){
            wordsList.add(words[i]);
        }
        
        //words�뿉  target�씠 �뾾�쑝硫� 0�쓣 return;
        if(!wordsList.contains(target))
            return 0;
        
        //dfs �떆�옉
        dfs(begin, target, wordsList, 0);

        return answer;
    }
    
    // �븣�뙆踰녹씠 �븯�굹留� 李⑥씠 �굹�뒗吏� �솗�씤
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
