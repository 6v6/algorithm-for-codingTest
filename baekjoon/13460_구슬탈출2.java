import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static char[][] map;
    public static boolean[][][][] visited = new boolean[10][10][10][10];

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        marble mb = new marble();
        mb.count = 0;

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){  
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    mb.ry = i;
                    mb.rx = j;
                }
                if(map[i][j] == 'B'){
                    mb.by = i;
                    mb.bx = j;
                }
            }
        }
        
        int result = bfs(mb);

        System.out.println(result);

        


    }

    public static int bfs(marble mb){
        Queue<marble> qu = new LinkedList<marble>();
        int next_rx, next_ry, next_bx, next_by, next_count;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int result = -1;
        
        visited[mb.ry][mb.rx][mb.by][mb.bx] = true;
        qu.add(mb);

        while(!qu.isEmpty()){

            marble cur_mb = qu.poll();

            if(cur_mb.count > 10)
                break;

            if(map[cur_mb.ry][cur_mb.rx] == 'O' && map[cur_mb.by][cur_mb.bx] != 'O'){
                result=cur_mb.count;
                return result;
            }

            for(int i = 0; i<4; i++) {
                next_ry = cur_mb.ry;
                next_rx = cur_mb.rx;
                next_by = cur_mb.by;
                next_bx = cur_mb.bx;
                next_count = cur_mb.count;

                while(true){ //빨간 구슬 이동
                    if(map[next_ry][next_rx] != 'O' && map[next_ry][next_rx] != '#'){
                        next_ry += dy[i]; 
                        next_rx += dx[i]; 
                    }
                    else {
                        if(map[next_ry][next_rx] == '#'){
                            next_ry -= dy[i]; 
                            next_rx -= dx[i];
                        }
                        break;
                    }
                }

                while(true){  //파란 구슬 이동
                    if(map[next_by][next_bx] != 'O' && map[next_by][next_bx] != '#'){
                        next_by += dy[i]; 
                        next_bx += dx[i];
                    }
                    else{
                        if(map[next_by][next_bx] == '#'){
                            next_by -= dy[i]; 
                            next_bx -= dx[i];
                        }
                        break;
                    }
                }

                if(next_ry == next_by && next_rx == next_bx){
                    if(map[next_ry][next_rx]!='O'){
                        int r_dist = Math.abs(next_ry-cur_mb.ry) + Math.abs(next_rx-cur_mb.rx); 
                        int b_dist = Math.abs(next_by-cur_mb.by) + Math.abs(next_bx-cur_mb.bx); 
                        if(r_dist > b_dist){
                            next_ry -= dy[i]; 
                            next_rx -= dx[i];
                        }
                        else{
                            next_by -= dy[i]; 
                            next_bx -= dx[i];
                        }

                    }
                }
                 
                if(!visited[next_ry][next_rx][next_by][next_bx]){
                    visited[next_ry][next_rx][next_by][next_bx] = true;
                    marble next_mb = new marble(next_ry, next_rx, next_by, next_bx,++next_count);
                    qu.add(next_mb);
                }


            }
        }

        return result;
    }


}

class marble{
    int rx;
    int ry;
    int bx;
    int by;
    int count;

    public marble(int ry, int rx, int by, int bx, int count){
        this.ry = ry;
        this.rx = rx;
        this.by = by;
        this.bx = bx;
        this.count = count;
    }
    
    public marble(){
        
    }
}