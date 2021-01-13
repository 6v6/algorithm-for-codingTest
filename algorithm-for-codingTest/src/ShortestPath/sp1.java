package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//����
//�켱���� ť�� Ȱ���� ���ͽ�Ʈ�� �˰���
class Node implements Comparable<Node> {
	// �켱 ���� �񱳸� ���� Comparable �������̽� ���
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

	// �Ÿ��� ª�� ���� ���� �켱������ �������� ����
	@Override
	public int compareTo(Node other) {
		if (this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class sp1 {

	public static final int INF = (int)1e9; //������ �ǹ��ϴ� ������ 10�� ����
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	// �ִ� �Ÿ� ���̺�
	public static int[] d = new int[30001];

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue();
		
		//���� ���� �������� �Ÿ��� 0
		pq.offer(new Node(start, 0));
		d[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance(); //���� ��� �Ÿ�
			int now = node.getIndex(); //���� ���
			
			//�̹� ó���� �� �ִ� ����� ����
			if(d[now] < dist) continue;
			
			//���� ���� ����� �ٸ� ������ ������ Ȯ��
			for(int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				//���� ��带 ���ļ�, �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ������ ����
		int m = sc.nextInt(); // ���(����)�� ����
		int c = sc.nextInt(); // �޽����� �������� �ϴ� ����
		
		//�׷��� �ʱ�ȭ
		for(int i = 0; i <=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		//�׷��� ���� �Է¹ޱ�
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			graph.get(x).add(new Node(y,z));
		}
		
		Arrays.fill(d,  INF);
		
		dijkstra(c);
		
		//���� �� �� �ִ� ����� ����
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
