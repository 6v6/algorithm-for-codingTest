package DFSBFS;

class Solution1 {

    public int solution(int n, int[][] computers) {    
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(n, computers, visited, i);
            }
        }
        return answer;
    }
    
    public void dfs(int n, int[][] computers, boolean[] visited, int node){
        
        visited[node] = true;
        
        for(int i = 0; i < n; i++){
            if( i != node && computers[node][i] ==1 && !visited[i]){
                dfs(n, computers, visited, i);
            }
        }
        
    }
}
