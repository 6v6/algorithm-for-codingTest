package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//최소비용 구하기
//다익스트라 알고리즘
class Node implements Comparable<Node> {
	int y;
	int distance;

	public Node(int y, int distance) {
		this.y = y;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node arg0) {
		if (this.distance < arg0.distance)
			return -1;
		return 1;
	}
}
public class boj1916 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		
		//최단거리 테이블
		int[] d = new int[n];
		int INF = (int)1e9;
		
		Arrays.fill(d, INF);
		

		//그래프 초기화
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Node>());
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int distance = sc.nextInt();
			graph.get(x).add(new Node(y, distance));
		}
		
		int start = sc.nextInt()-1;
		int end = sc.nextInt()-1;
		
		pq.add(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int distance = node.distance;
			int index = node.y;
			
			if(d[index] < distance) continue;
			
			for(int i = 0; i < graph.get(index).size(); i++) {
				int cost = d[index] + graph.get(index).get(i).distance;
				if(cost < d[graph.get(index).get(i).y]) {
					d[graph.get(index).get(i).y] = cost;
					pq.offer(new Node(graph.get(index).get(i).y, cost));
				}
				
			}
		}
		
		System.out.println(d[end]);
	}
}
