package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * �����ٸ� �˰��� ��, SJF�� �����ϴ� ����
 * ���� ���
 * 1. ��û �ð��� �������� �۾����� �������� �����Ѵ�
 * 2. ���� �ð��̳��� �ִ� �۾����� �켱���� ť�� ��´�. �� ��, �켱���� ť�� �۾��ð��� �������� �������� ���ĵȴ�. 
 * 3. ť�� ���������, ���� ����ð��� ����� �۾��� ��ûŸ������ ���� �ð��� �����Ѵ�.*
 * 4. ť���� ���� �۾��ð��� ���� ª�� �۾��� ���� �����Ѵ�. (���� �ð��� �۾��� ���� �ð����� �����ϰ�, ressulTime�� �۾��� ��û���� ������� �ɸ��ð��� ���Ѵ�.)
 * 5. 2~4�� ������ �۾��� ���������� �ݺ��Ѵ�.
 * 6. ��սð��� ����Ѵ�.
 * */
public class diskController {
	public int solution(int[][] jobs) {
		int answer = 0;

		// 1 �۾� �ð��� �������� �������� �ϴ� PQ����
		PriorityQueue<int[]> pq = new PriorityQueue<>((num1, num2) -> num1[1] - num2[1]);
		// 2 ��û�ð� �������� �������� ����
		Arrays.sort(jobs, (num1, num2) -> num1[0] - num2[0]);

		// �Ϸ�� �۾��� ��
		int count = 0;
		// ����ð�
		int currentTime = 0;
		// �� �۾��� ��û���� ������� �ɸ� �ð��� ��
		int resultTime = 0;
		// �۾��� �ε���
		int i = 0;

		while (count < jobs.length) {
			// pq�� �۾� �߰�
			while (i < jobs.length && currentTime >= jobs[i][0]) {
				pq.offer(jobs[i]);
				i++;
			}

			if (pq.isEmpty()) {
				currentTime = jobs[i][0];
			} else {
				int[] job = pq.poll();
				currentTime += job[1];
				resultTime += currentTime - job[0];
				count++;
			}

		}

		answer = resultTime / jobs.length;
		return answer;
	}
}
