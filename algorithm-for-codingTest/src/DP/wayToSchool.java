package DP;

//���
/*
 * �и� DP�� �ذ��Ѱ� ������.. ȿ���� ��� ����..
 * �ݺ�Ƚ���� �ٿ����ϳ� ����ߴµ� map�� �־��ٶ� ������ ���� �־��ִ� �۾��� �Ź� �߾�� �Ѵ�����
 * ����� ������ �ƴѵ� ���� ���ε�.. ������ �� �� �о ���
 */
public class wayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = 0;
            }
        }
        //���� ���� 1
        map[0][0] = 1;
        //��������
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
