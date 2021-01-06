package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class lifeboat {
	 public int solution(int[] people, int limit) {
	        int answer = 0;
	        int num = 0;
	        
	        ArrayList<Integer> al = new ArrayList<>();
	        for(int i = 0; i < people.length; i++){
	            al.add(people[i]);
	        }
	        
	        Collections.sort(al);
	        int si = 0;
	        for(int i = al.size()-1; num < people.length; i--){
	            int temp = al.get(i); //현재 최대값
	            int extra = limit - temp; //여유공간
	            int small = al.get(si); //현재 작은값
	            if(small <= extra) {
	                si++; //둘이 탑승
	                num++;
	            }
	            answer++;
	            num++;
	        }
	        return answer;
	    }
}
