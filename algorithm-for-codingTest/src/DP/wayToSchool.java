package DP;

//등굣길
/*
 * 분명 DP로 해결한거 같은데.. 효율성 통과 못함..
 * 반복횟수를 줄여야하나 고민했는데 map에 넣어줄때 나머지 값을 넣어주는 작업을 매번 했어야 한던거임
 * 어려운 문제는 아닌데 길의 수인데.. 문제를 잘 못 읽어서 헤맴
 */
public class wayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = 0;
            }
        }
        //시작 값을 1
        map[0][0] = 1;
        //물웅덩이
        for(int i = 0; i < puddles.length; i++){
            map[puddles[i][0]-1][puddles[i][1]-1] = -1;  
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int right = 0;
                int down = 0;
                if(map[i][j] == -1 ) continue;
                if(j > 0 && map[i][j-1] != -1)
                    right = map[i][j-1];
                if (i > 0 && map[i-1][j] != -1)
                    down = map[i-1][j];
                
                map[i][j] = (right+down+map[i][j]) % 1000000007;
            }
        }
        return (map[m-1][n-1]) % 1000000007;
    }
	

}
