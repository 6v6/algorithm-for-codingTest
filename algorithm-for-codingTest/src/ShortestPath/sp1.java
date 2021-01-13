package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//전보
//우선순위 큐를 활용한 다익스트라 알고리즘
class Node implements Comparable<Node> {
	// 우선 순위 비교를 위해 Comparable 인터페이스 상속
	private int index;
	private int distance;

	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return this.index;
	}

	public int getDistance() {
		return this.distance;
	}

	// 거리가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Node other) {
		if (this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class sp1 {

	public static final int INF = (int)1e9; //무한을 의미하는 값으로 10억 설정
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	// 최단 거리 테이블
	public static int[] d = new int[30001];

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue();
		
		//시작 노드로 가기위한 거린느 0
		pq.offer(new Node(start, 0));
		d[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance(); //현재 노드 거리
			int now = node.getIndex(); //현재 노드
			
			//이미 처리된 적 있는 노드라면 무시
			if(d[now] < dist) continue;
			
			//현재 노드와 연결된 다른 인접한 노드들을 확인
			for(int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				//현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 도시의 개수
		int m = sc.nextInt(); // 통로(간선)의 개수
		int c = sc.nextInt(); // 메시지를 보내고자 하는 도시
		
		//그래프 초기화
		for(int i = 0; i <=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		//그래프 정보 입력받기
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			graph.get(x).add(new Node(y,z));
		}
		
		Arrays.fill(d,  INF);
		
		dijkstra(c);
		
		//도달 할 수 있는 노드의 개수
		int count = 0;
		int maxD = 0;
		
		for(int i = 0; i <= n; i++) {
			if(d[i] != INF) {
				count++;
				maxD = Math.max(maxD, d[i]);
			}
		}
		
		System.out.println((count-1)+" "+maxD);
		

	}
}
