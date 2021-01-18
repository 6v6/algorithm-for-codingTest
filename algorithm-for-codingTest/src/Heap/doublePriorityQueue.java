package Heap;

import java.util.ArrayList;
import java.util.Collections;
/*
 * 우선 순위 큐 문제라.. heap을 꼭 사용해서 풀어야 하나 싶었는디
 * list로 하는 풀이만 생각나서 풀이했는데 해결함
 * list는 계속 정렬해주는 작업을 추가해서 풀이함
 * pq를 이용할 경우엔 우선순위가 다른 2개의 큐를 선언해서 
 * 하나의 pq에서 지워진 값을 다른 pq에서도 삭제하는 식으로 해결하면 됨
 * */
public class doublePriorityQueue {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		ArrayList<Integer> al = new ArrayList<>();
		
		for (int i = 0; i < operations.length; i++) {
			String s = operations[i];
			if (s.charAt(0) == 'I') {
				s = s.substring(2, operations[i].length());
				al.add(Integer.parseInt(s));
				Collections.sort(al);
			} else if (s.equals("D 1") && !al.isEmpty()) { // 최대값 삭제
				al.remove(al.size() - 1);
			} else if (s.equals("D -1") && !al.isEmpty()) { // 최소값삭제
				al.remove(0);
			}
		}

		if (al.isEmpty()) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = al.get(al.size() - 1);
			answer[1] = al.get(0);
		}
		return answer;
	}
}
