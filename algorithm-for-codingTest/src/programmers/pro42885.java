package programmers;

import java.util.ArrayList;
import java.util.Collections;

//����Ʈ
public class pro42885 {
	class Solution {
		public int solution(int[] people, int limit) {
			int answer = 0;
			ArrayList<Integer> al = new ArrayList<>();

			for (int i = 0; i < people.length; i++) {
				al.add(people[i]);
			}
			Collections.sort(al);

			int si = 0;
			for (int i = al.size() - 1; i >= si; i--) {
				int target = al.get(i); // �ִ밪�� ����
				int remain = limit - target;
				answer++;
				if (si < i && remain >= al.get(si)) {
					si++;
				}
			}

			return answer;
		}
	}
}
