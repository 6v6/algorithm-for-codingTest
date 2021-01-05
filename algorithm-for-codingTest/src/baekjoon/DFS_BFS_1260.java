package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_1260{

    public static LinkedList<Integer>[] nodeList;
    public static void main(String[] args)throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        nodeList = new LinkedList[nodeCnt+1];

        for(int i = 0;  i <= nodeCnt; i++){
            nodeList[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i < lineCnt; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            nodeList[node1].add(node2);
            nodeList[node2].add(node1);

            Collections.sort(nodeList[node1]);
            Collections.sort(nodeList[node2]);
        }
        
        StringBuilder dfsResult = new StringBuilder();
        StringBuilder bfsResult = new StringBuilder();

        boolean[] dfsVisited = new boolean[nodeCnt+1];
        boolean[] bfsVisited = new boolean[nodeCnt+1];
      
        dfs(startNode, dfsVisited, dfsResult);
        bfs(startNode, bfsVisited, bfsResult);
      
        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }

    public static void dfs(int node, boolean[] visited, StringBuilder sb){
        if(visited[node]) return;

        visited[node] = true;
        sb.append(node + " ");

        for(int nextNode : nodeList[node]){
            dfs(nextNode, visited, sb);
        }
    }

    public static void bfs(int node, boolean[] visited, StringBuilder sb){ //�떆�옉�끂�뱶, 諛⑸Ц�솗�씤諛곗뿴, 寃쎈줈瑜� �떞�뒗 臾몄옄�뿴
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node); 

        while(!queue.isEmpty()){    
            node = queue.poll();
            if(visited[node]) continue;

            visited[node] = true;
            sb.append(node + " ");
            for(int nextNode : nodeList[node]){
                queue.add(nextNode);
            }
        }
    }

    
}