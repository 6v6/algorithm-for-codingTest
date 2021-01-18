package Heap;

import java.util.ArrayList;
import java.util.Collections;
/*
 * �켱 ���� ť ������.. heap�� �� ����ؼ� Ǯ��� �ϳ� �;��µ�
 * list�� �ϴ� Ǯ�̸� �������� Ǯ���ߴµ� �ذ���
 * list�� ��� �������ִ� �۾��� �߰��ؼ� Ǯ����
 * pq�� �̿��� ��쿣 �켱������ �ٸ� 2���� ť�� �����ؼ� 
 * �ϳ��� pq���� ������ ���� �ٸ� pq������ �����ϴ� ������ �ذ��ϸ� ��
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
			} else if (s.equals("D 1") && !al.isEmpty()) { // �ִ밪 ����
				al.remove(al.size() - 1);
			} else if (s.equals("D -1") && !al.isEmpty()) { // �ּҰ�����
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
