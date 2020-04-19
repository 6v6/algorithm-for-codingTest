import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;

        int cnt = 0;
        List<Integer> answerList = new ArrayList<Integer>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        TreeMap<Integer, Integer> tm;

        for(int i=0; i<genres.length; i++){
            if(hm.get(genres[i])==null){
                hm.put(genres[i],plays[i]);
            }else{ 
                hm.put(genres[i],hm.get(genres[i])+plays[i]);
            }
        }

        List<String> list = new ArrayList();
        list = sortByValue(hm); //value를 기준으로 정렬

        Iterator<String> iteratorGenres = list.iterator( ); 
         while(iteratorGenres.hasNext()) {
             String genre = iteratorGenres.next();
             tm = new TreeMap<Integer, Integer>(); //plays, 고유번호
             for(int j = 0; j<genres.length; j++){
                if(genre.equals(genres[j])){
                    if(tm.get(-plays[j])==null){
                        tm.put(-plays[j],j);
                    }
                    else{
                        tm.put((-plays[j])+1,j);
                    }
                }
             }
           
            Iterator<Integer> iteratorKey = tm.keySet( ).iterator( );  
            int icnt = 0;
            while(iteratorKey.hasNext()&&icnt!=2) {
                cnt = 0;
                Integer key = iteratorKey.next();
                answerList.add(tm.get(key));
                cnt++;
                icnt++;
            }
         }

        answer = new int[answerList.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i]=answerList.get(i);
        }
        return answer;
    }

    public static List sortByValue(final Map map){
        List<String> list = new ArrayList(); //value를 기준으로 정렬한 값을 담음
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
          return ((Comparable) v2).compareTo(v1);
            }
        });
        return list;
    }

}