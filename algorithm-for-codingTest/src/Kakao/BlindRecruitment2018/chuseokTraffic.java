package Kakao.BlindRecruitment2018;

import java.util.ArrayList;
import java.util.Arrays;

public class chuseokTraffic {
	public int solution(String[] lines) {
		int answer = 0;
		Arrays.sort(lines);
		ArrayList<int[]> al = new ArrayList<>();

		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String[] times = line.split(" ");
			String[] s = times[1].split(":");

			int t = (int) (Double.parseDouble(times[2].substring(0, times[2].length() - 1)) * 1000); // ó���ð� t

			// ���� �Ϸ�ð�
			int endTime = 0;

			endTime += Integer.parseInt(s[0]) * 3600 * 1000;
			endTime += Integer.parseInt(s[1]) * 60 * 1000;
			endTime += (int) (Double.parseDouble(s[2]) * 1000);

			int startTime = endTime - t + 1;
			int[] temp = new int[2];
			temp[0] = startTime;
			temp[1] = endTime;
			al.add(temp);
		}

		// �� �α��� ���۰� ���� �������� �����츦 �����ϰ� �ִ밪�� ���Ѵ�.
		for (int i = 0; i < al.size(); i++) {
			int startMax = 0;
			int endMax = 0;
			int start = al.get(i)[0];
			int end = al.get(i)[1];
			for (int j = 0; j < al.size(); j++) {
				int targets = al.get(j)[0];
				int targete = al.get(j)[1];
				if (start <= targete && start + 999 >= targets)
					startMax++;
				if (end <= targete && end + 999 >= targets)
					endMax++;
			}

			answer = Math.max(answer, startMax);
			answer = Math.max(answer, endMax);
		}

		return answer;
	}
}
