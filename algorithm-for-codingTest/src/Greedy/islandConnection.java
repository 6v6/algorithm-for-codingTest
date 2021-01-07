package Greedy;

import java.util.Arrays;

//�� �����ϱ�, ũ�罺Į �˰��� �̿�
public class islandConnection {
	 public int solution(int n, int[][] costs) {
	        int answer = 0;
	        
	        //�������� �������� ����
	        Arrays.sort(costs,(c1, c2) -> {
	            return Integer.compare(c1[2],c2[2]);
	        });
	        
	        //�θ� �迭 �ʱ�ȭ
	        int[] parent = new int[n];
	        for(int i = 0; i < n; i++){
	            parent[i] = i;
	        }
	        
	        for(int i = 0; i < costs.length;  i++){
	            if(!findParent(parent, costs[i][0], costs[i][1])){
	                unionParent(parent, costs[i][0], costs[i][1]);
	                answer += costs[i][2];
	            }
	        }
	        
	        
	        return answer;
	    }
	    
	    //getParent
	    public int getParent(int[] parent, int x){
	        if(parent[x] == x) return x;
	        return getParent(parent, parent[x]);
	    }
	    
	    
	    //�θ� ��� ��ġ�� (����)
	    public void unionParent(int[] parent, int x, int y){
	        x = getParent(parent, x);
	        y = getParent(parent, y);
	        
	        if( x < y ) parent[y] = x;
	        else parent[x] = y;
	    }
	    
	    //���� �θ� ��带 �������� Ȯ��
	    public boolean findParent(int[] parent, int x, int y){
	        x = getParent(parent, x);
	        y = getParent(parent, y);
	        
	        if(x == y)
	            return true;
	        else
	            return false;
	    }
	    
}
