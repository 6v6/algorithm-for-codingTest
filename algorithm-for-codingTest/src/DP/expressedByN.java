package DP;

import java.util.ArrayList;

//N으로 표현
public class expressedByN {
	
	 public int solution(int N, int number) {
	        
	        //두 수가 같이 연산할 필요가 없는 경우
	        if(N == number)
	            return 1;
	        
	        //전체 값을 담는 리스트
	        ArrayList<ArrayList> s = new ArrayList<>();
	        
	        //S[0] : N을 1개 사용
	        ArrayList<Integer> first = new ArrayList<>();
	        first.add(N);
	        s.add(first);
	       
	        //S[1]~S[7] : N을 2~8개 사용
	        for(int i = 1; i < 8; i++){
	            ArrayList<Integer> al = new ArrayList<>();
	            
	            //이어붙여서 만드는 수
	            String str = "";
	            for(int l = 0; l <= i; l++) str += String.valueOf(N);
	            al.add(Integer.parseInt(str));
	            
	            //사칙 연산 계산
	            for(int j = 0; j < i; j++ ){
	                for(int p = 0; p < s.get(j).size(); p++){
	                    for(int q = 0; q < s.get(i-j-1).size(); q++){
	                        int a = (int)s.get(j).get(p);
	                        int b = (int)s.get(i-j-1).get(q);
	                        al.add(a + b);
	                        al.add(a - b);
	                        al.add(a * b);
	                        if(b != 0)
	                            al.add(a / b);
	                    }
	                }
	            }
	            if(al.contains(number)){
	                return i+1;
	            }
	            s.add(al);
	        }

	        return -1;
	    }

}
