package DP;

import java.util.ArrayList;

//N���� ǥ��
public class expressedByN {
	
	 public int solution(int N, int number) {
	        
	        //�� ���� ���� ������ �ʿ䰡 ���� ���
	        if(N == number)
	            return 1;
	        
	        //��ü ���� ��� ����Ʈ
	        ArrayList<ArrayList> s = new ArrayList<>();
	        
	        //S[0] : N�� 1�� ���
	        ArrayList<Integer> first = new ArrayList<>();
	        first.add(N);
	        s.add(first);
	       
	        //S[1]~S[7] : N�� 2~8�� ���
	        for(int i = 1; i < 8; i++){
	            ArrayList<Integer> al = new ArrayList<>();
	            
	            //�̾�ٿ��� ����� ��
	            String str = "";
	            for(int l = 0; l <= i; l++) str += String.valueOf(N);
	            al.add(Integer.parseInt(str));
	            
	            //��Ģ ���� ���
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
