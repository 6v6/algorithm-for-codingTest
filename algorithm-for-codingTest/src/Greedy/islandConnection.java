package Greedy;

import java.util.Arrays;

//섬 연결하기, 크루스칼 알고리즘 이용
public class islandConnection {
	 public int solution(int n, int[][] costs) {
	        int answer = 0;
	        
	        //비용순으로 오름차순 정렬
	        Arrays.sort(costs,(c1, c2) -> {
	            return Integer.compare(c1[2],c2[2]);
	        });
	        
	        //부모 배열 초기화
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
	    
	    
	    //부모 노드 합치기 (연결)
	    public void unionParent(int[] parent, int x, int y){
	        x = getParent(parent, x);
	        y = getParent(parent, y);
	        
	        if( x < y ) parent[y] = x;
	        else parent[x] = y;
	    }
	    
	    //같은 부모 노드를 가지는지 확인
	    public boolean findParent(int[] parent, int x, int y){
	        x = getParent(parent, x);
	        y = getParent(parent, y);
	        
	        if(x == y)
	            return true;
	        else
	            return false;
	    }
	    
}
