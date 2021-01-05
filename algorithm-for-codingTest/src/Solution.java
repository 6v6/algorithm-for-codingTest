import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static void main(String[] args) {
//    	System.out.println(solution("aabab"));
//    	System.out.println(solution("dog"));
//    	System.out.println(solution("aa"));
//    	System.out.println(solution("baaa"));
//    	System.out.println(solution("aaa"));
    	
//    	String[] S = {"abc", "bca", "dbe"};
//    	System.out.println(solution2(S));
//    	String[] S1 = {"zzzz", "ferz", "zdsr", "fgtd"};
//    	System.out.println(solution2(S1));
//    	String[] S2 = {"gr", "sd", "rg"};
//    	System.out.println(solution2(S2));
//    	String[] S3 = {"bdafg", "ceagi"};
//    	System.out.println(solution2(S3));
    	
    	int[] A = {1, 2, 1};
    	System.out.println(solution3(A));
    	
    	int[] A2 = {2, 1, 4, 4};
    	System.out.println(solution3(A2));
    	
    	int[] A3 = {6, 2, 3, 5, 6, 3};
    	System.out.println(solution3(A3));
	}
    public static int solution3(int[] A) {
        // write your code in Java SE 8
    	
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	ArrayList<Integer> needList = new ArrayList<Integer>();
    	ArrayList<Integer> checkList = new ArrayList<Integer>();
    	
    	int count = 0;
    	
    	for(int i = 0; i < A.length; i++) {
    		al.add(A[i]);
    	}
    	
    	// 1-N 중 없는 값 확인
    	for(int i = 1; i <= A.length; i++) {
    		if(!al.contains(i)) 
    			needList.add(i);	
    	}
    	
    	Collections.sort(al);
    	int index = 0;
    	//중복된 값 확인
    	for(Integer item : al){
    		if(count > 1000000000)
    			return -1;
            if(!checkList.contains(item)) {
            	checkList.add(item);
            }
            else {
            	count = (int) (count + Math.abs(needList.get(index) - item));
            	index++;
            }
            	
        }
    	return count;
    } 
    
    
    public static int[] solution2(String[] S) {
        // write your code in Java SE 8
    	// write your code in Java SE 8
    	int[] result;
    	int N = S[0].length();
    

    	for(int i = 0; i < S.length-1; i++) {
    		for(int j = i+1; j < S.length; j++) {
        		for(int k = 0; k < N; k++) {
        			if(S[i].charAt(k) == S[j].charAt(k)) {
        				result = new int[3];
        				result[0] = i;
        				result[1] = j;
        				result[2] = k;
        				return result;
        			}
        		}
        	}
    	}
    	
        result = new int[0];
    	return result;
    
    }
    
    
    public static int solution(String S) {
        // write your code in Java SE 8
    	if(S.equals("aa"))
    		return 0;
    	else if(S.contains("aaa"))
    		return -1;
    	
    	int count = 0;
    	int checkA = 0;
    	for(int i = 0; i < S.length(); i++) {
    		if(S.charAt(i) == 'a') {
    			checkA++;
    		}
    		else {
    			if(checkA == 0) {
    				count = count + 2;
    			}
    			else if(checkA == 1) {
    				count = count + 1;
    			}
    			checkA = 0;
    		}
    	}
    	
    	if(checkA == 0) {
			count = count + 2;
		}
		else if(checkA == 1) {
			count = count + 1;
		}
    	
    	
    	return count;
    }
    
    
}
