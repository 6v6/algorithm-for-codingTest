package Sort;
import java.util.*;
class Solution3 {
    public int solution(int[] citations) {
        int index = 0;
        int n = citations.length;
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++){
            al.add(citations[i]);
        }
        
        Collections.sort(al);
        
        //筌뤴뫀諭� 占쎈걠�눧紐꾩벥 占쎌뵥占쎌뒠 占쎌뒒占쎈땾揶쏉옙 占쎈걠�눧紐꾩벥 揶쏉옙占쎈땾癰귣��뼄 筌띾‘�뱽 占쎈르
        if(al.get(0) >= n){
                return n;
        }
        
        while(index < n){
            int h = al.get(index);
            if( h > n - index){
                System.out.println(h);
                System.out.println(n - index);
                while(h > al.get(index-1) ){
                    System.out.println(h);
                    if( --h <= n - index)
                        return h;
                }
                return al.get(index-1);
            }
            index++;
        }
        return al.get(0);
    }
}
