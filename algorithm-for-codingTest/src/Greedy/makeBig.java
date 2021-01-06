package Greedy;

import java.util.Stack;

public class makeBig {
	
	 public String solution(String number, int k) {
	        char[] input = number.toCharArray();
	        Stack<Character> st = new Stack<>();
	           
	        for(int i =  0; i < number.length(); i++){
	            while(!st.isEmpty() && k > 0 && st.peek() < input[i]){
	                st.pop();
	                k--;
	            }
	             st.push(input[i]);
	        }    
	        
	        StringBuilder sb = new StringBuilder();
	        while(!st.empty()){
	            if(k != 0){
	                st.pop();
	                k--;
	            }
	            else{
	               sb.append(st.pop());
	            }
	        }
	        return sb.reverse().toString();
	    }
	
	
	
/**** recursive함수 만들어서 풀이--> 메모리 초과
	ArrayList<String> al = new ArrayList<>();

	public String solution(String number, int k) {
		String answer = "";
		int length = number.length() - k;
		for (int i = 0; i <= length; i++) {
			recur(i, 1, number.charAt(i) + "", number, length);
		}

		Collections.sort(al);
		answer = al.get(al.size() - 1);
		return answer;

	}

	public void recur(int i, int n, String s, String number, int length) {
		if (s.length() == length || n > number.length()) {
			if (s.length() == length)
				al.add(s);
			return;
		}
		if (s.length() > length)
			return;

		n++;
		for (int j = i + 1; j < number.length(); j++) {
			String ns = s + number.charAt(j) + "";
			recur(j, n, ns, number, length);
		}

	}
*/
}
