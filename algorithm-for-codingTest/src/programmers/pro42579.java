package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pro42579 {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		// ������ ��� �迭
		ArrayList<Integer> result = new ArrayList<>();

		// �帣, �����
		Map<String, Integer> count = new HashMap<>();

		// ��ȣ, ���Ƚ��

		for (int i = 0; i < genres.length; i++) {
			if (count.containsKey(genres[i])) {
				int playCount = count.get(genres[i]);
				count.put(genres[i], playCount + plays[i]);
			} else
				count.put(genres[i], plays[i]);
		}

		List<String> keySetList = new ArrayList<>(count.keySet());
		// �帣�� ���Ƚ�� ��ŭ ����
		Collections.sort(keySetList, (o1, o2) -> (count.get(o2).compareTo(count.get(o1))));

		for (String key : keySetList) {
			Map<Integer, Integer> temp = new HashMap<>();
			for (int i = 0; i < plays.length; i++) {
				if (key.equals(genres[i])) {
					temp.put(i, plays[i]);
				}
			}

			List<Integer> genrekeys = new ArrayList<>(temp.keySet());
			Collections.sort(genrekeys, (o1, o2) -> (temp.get(o2).compareTo(temp.get(o1))));

			if (genrekeys.size() >= 2) {
				if (temp.get(genrekeys.get(0)) == temp.get(genrekeys.get(1))) {
					if (genrekeys.get(0) > genrekeys.get(1)) {
						result.add(genrekeys.get(1));
						result.add(genrekeys.get(0));
					}
				} else {
					result.add(genrekeys.get(0));
					result.add(genrekeys.get(1));
				}
			} else {
				// �帣 ���� �ϳ��� ���
				result.add(genrekeys.get(0));
			}
		}

		answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}
}
