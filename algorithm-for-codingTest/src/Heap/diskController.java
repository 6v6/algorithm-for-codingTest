package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 스케줄링 알고리즘 중, SJF를 구현하는 문제
 * 구현 방법
 * 1. 요청 시간을 기준으로 작업들을 오름차순 정렬한다
 * 2. 현재 시간이내에 있는 작업들을 우선순위 큐에 담는다. 이 떄, 우선순위 큐는 작업시간을 기준으로 오름차순 정렬된다. 
 * 3. 큐가 비어있으면, 가장 실행시간이 가까운 작업의 요청타임으로 현재 시간을 변경한다.*
 * 4. 큐에서 현재 작업시간이 가장 짧은 작업을 꺼내 수행한다. (현재 시간을 작업이 끝난 시간으로 변경하고, ressulTime에 작업의 요청부토 종료까지 걸린시간을 더한다.)
 * 5. 2~4의 과정을 작업이 끝날때까지 반복한다.
 * 6. 평균시간을 계산한다.
 * */
public class diskController {
	public int solution(int[][] jobs) {
		int answer = 0;

		// 1 작업 시간을 기준으로 오름차순 하는 PQ선언
		PriorityQueue<int[]> pq = new PriorityQueue<>((num1, num2) -> num1[1] - num2[1]);
		// 2 요청시간 기준으로 오름차순 정렬
		Arrays.sort(jobs, (num1, num2) -> num1[0] - num2[0]);

		// 완료된 작업의 수
		int count = 0;
		// 현재시간
		int currentTime = 0;
		// 각 작업의 요청부터 종료까지 걸린 시간의 합
		int resultTime = 0;
		// 작업의 인덱스
		int i = 0;

		while (count < jobs.length) {
			// pq에 작업 추가
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
