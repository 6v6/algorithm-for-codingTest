package Hash;

import java.util.*;
class ¿ß¿Â {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<String,Integer>();
        for(int i = 0; i < clothes.length; i++){
            if(hm.get(clothes[i][1]) == null){
                hm.put(clothes[i][1],1);
            }
            else{
                int count = hm.get(clothes[i][1])+1;
                hm.put(clothes[i][1],count);
            }
        }
        Set keyset = hm.keySet();
        for(Object key : keyset){
            answer *= hm.get(key)+1;
        }
        return answer-1;
    }

}