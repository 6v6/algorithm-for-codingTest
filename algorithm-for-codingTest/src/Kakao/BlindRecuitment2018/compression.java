package Kakao.BlindRecuitment2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class compression {
	public int[] solution(String msg) {
		int[] answer;
		// ������ ���� ����Ʈ
		ArrayList<Integer> al = new ArrayList<Integer>();
		// ���ڿ��� ���ι�ȣ�� ��� ���� hm
		HashMap<String, Integer> hm = new HashMap<>();
		// �Է¹��� ���ڸ� ����
		Queue<Character> qu = new LinkedList<>();
		int index = 0;

		for (int i = 0; i < 26; i++) {
			char k = (char) ('A' + i);
			int v = k - 'A' + 1;
			hm.put(Character.toString(k), v);
		}

		for (int i = 0; i < msg.length(); i++) {
			qu.offer(msg.charAt(i));
		}

		String w = "";
		while (!qu.isEmpty()) {
			w += Character.toString(qu.peek()); // kao
			if (hm.containsKey(w)) {
				qu.poll();
				if (!qu.isEmpty())
					continue;
			}

			if (!qu.isEmpty()) {
				String wc = w;
				w = w.substring(0, w.length() - 1);
				hm.put(wc, hm.size() + 1);
				al.add(hm.get(w));
				w = "";
			} else {
				al.add(hm.get(w));
			}
		}

		answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}
		return answer;
	}

}
