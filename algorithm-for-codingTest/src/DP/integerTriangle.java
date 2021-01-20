package DP;

//정수 삼각형
public class integerTriangle {

	// bottom-up방식으로 풀이
	// 삼각형 밑에서부터 큰 값을 선택하여 update되도록 함.
	public int solution(int[][] triangle) {
		for (int i = triangle.length - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++)
				triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
		}

		// 꼭대기에 최대값에 합이 계산됨
		return triangle[0][0];
	}

}
