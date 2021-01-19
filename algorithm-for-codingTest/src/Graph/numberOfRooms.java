package Graph;

import java.util.HashMap;

/* 방의 개수
 * ㅠㅠ 넘 어렵게 풀었음... 자바 문법을 이용해서 체크하려고 하니, x,y점과 방향모두 어떻게 저장해야할지 고민이 컸다.
 * hashmap<Long, boolean> 배열의 형태를 이용헀다.
 * key값으론 x*100000+y값을 넣어 x,y의 값이 하나의 long형으로 저장되도록 하였다.
 * value값으론  x,y점이 어떤 방향으로 이동했는지를 저장하기 위해 boolean 배열을 사용하였다. 방향(0~7)을 인덱스값으로 하여 방문한적이 있다면  true로 체크하였다.
 * 
 * 알고리즘을 짤 때, 체크해야하는 것은 2가지
 * 첫번째, 점을 방문한 적이 있는지 체크
 * 두번째, 점을 방문한적이 있다면 어떤 방향으로 방문했는지 체크
 * 두번째를 생각할 때, 방향이 달라도 간선을 동일하게 취급한다
 * 즉, 현재위치 -> 다음위치 로 이동한 값과 현재위치<-다음위치로 이동한 값이 같은것으로 파악한다.
 * 예시) 
 * 0,0에서 6번 방향으로 이동하면 다음위치는 0,-1이 된다.
 * 0,-1에서 2번 방향으로 이동하면 다음위치는 0,0이 된다.
 * 위에 두 가지 경우 중 어떤 이동이 발생하든 같은 간선이기 때문에 두가지 모두 발생한것으로 체크한다.
 * 
 * 알고리즘 동작 과정
 * 1 초기 값으로 현재 위치를 0,0으로 지정
 * 2 다음으로 이동할 점을 방문한적이 있는지 확인한다.
	  2-1 방문한적이 있다면 이전에 이동했던 방향인지 확인한다.
	  2-1-1 이전에 이동한 방향이 아니라면 방이 생긴것으로 answer을 증가시킨다.
	  2-1-2 이동한 방향이 대각선이라면 대각선 크로스가 생성됐는지 확인한다. 크로스가 생성됐다면 answer증가시킨다.
	  2-2 방문한적이 없다면 현재 이동한 점을 방문한 것으로 체크하고 방향또한 저장한다.
	  2-2-1 이동한 방향이 대각선이라면 대각선 크로스가 생성됐는지 확인한다. 크로스가 생성됐다면 answer증가시킨다.
 * 3 현재 x,y값을 다음 값으로 변경한다.
 * 4 이동한 만큼 2~3번의 과정을 반복한다.
 * 
 * 다른 사람들의 코드를 찾아보니 문자열 형태로 이동한 위치와, 점을 저장한 경우가 있는데 이게 훨씬 간편하고 가독성 코드를 작성할 수 있는듯!
 * 그리고 대각선 체크를 나처럼 if문으로 체크해서 확인하는게 아니고 for문을 두번돌려서 체크하면 쉽게 확인 가능! 
 * */
public class numberOfRooms {
	public int solution(int[] arrows) {
		int answer = 0;
		int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
		// 점, 방향
		HashMap<Long, boolean[]> mp = new HashMap<>();

		// 현재 위치
		int cx = 0;
		int cy = 0;
		Long xy = Long.valueOf(cx) * 100000 + Long.valueOf(cy);
		boolean[] check = new boolean[8];
		mp.put(xy, check);

		for (int i = 0; i < arrows.length; i++) {
			// 다음 위치
			int nx = cx + dx[arrows[i]];
			int ny = cy + dy[arrows[i]];
			Long nxy = Long.valueOf(nx) * 100000 + Long.valueOf(ny);
			int narrow;
			if (arrows[i] < 4)
				narrow = arrows[i] + 4;
			else
				narrow = arrows[i] - 4;
			// 다음 위치를 방문한적이 있는지
			if (mp.containsKey(nxy)) {
				boolean[] c = mp.get(xy);
				boolean[] nc = mp.get(nxy);
				// 전에 이동을 했던 방향이 아니라면
				if (!c[arrows[i]] && !nc[narrow]) {
					// System.out.println(nx +" "+ny);
					answer++;
					c[arrows[i]] = true;
					nc[narrow] = true;
					mp.put(xy, c);
					mp.put(nxy, nc);

					// 대각선 크로스
					if (arrows[i] == 1) {
						int checky = ny - 1;
						Long crossCheck = Long.valueOf(nx) * 100000 + Long.valueOf(checky);
						if (mp.containsKey(crossCheck)) {
							boolean[] cc = mp.get(crossCheck);
							if (cc[3])
								answer++;
						}
					} else if (arrows[i] == 3) {
						int checky = ny - 1;
						Long crossCheck = Long.valueOf(nx) * 100000 + Long.valueOf(checky);
						if (mp.containsKey(crossCheck)) {
							boolean[] cc = mp.get(crossCheck);
							if (cc[1])
								answer++;
						}
					} else if (arrows[i] == 5) {
						int checky = ny + 1;
						Long crossCheck = Long.valueOf(nx) * 100000 + Long.valueOf(checky);
						if (mp.containsKey(crossCheck)) {
							boolean[] cc = mp.get(crossCheck);
							if (cc[7])
								answer++;
						}
					} else if (arrows[i] == 7) {
						int checky = ny + 1;
						Long crossCheck = Long.valueOf(nx) * 100000 + Long.valueOf(checky);
						if (mp.containsKey(crossCheck)) {
							boolean[] cc = mp.get(crossCheck);
							if (cc[5])
								answer++;
						}
					}
				}
			} else {

				// 방문한 것으로 체크
				boolean[] c = mp.get(xy);
				boolean[] nc = new boolean[8];
				c[arrows[i]] = true;
				nc[narrow] = true;
				mp.put(xy, c);
				mp.put(nxy, nc);
				
				// 대각선 크로스
				if (arrows[i] == 1) {
					int checky = ny - 1;
					Long crossCheck = Long.valueOf(nx) * 100000 + Long.valueOf(checky);
					if (mp.containsKey(crossCheck)) {
						boolean[] cc = mp.get(crossCheck);
						if (cc[3])
							answer++;
					}
				} else if (arrows[i] == 3) {
					int checky = ny - 1;
					Long crossCheck = Long.valueOf(nx) * 100000 + Long.valueOf(checky);
					if (mp.containsKey(crossCheck)) {
						boolean[] cc = mp.get(crossCheck);
						if (cc[1])
							answer++;
					}
				} else if (arrows[i] == 5) {
					int checky = ny + 1;
					Long crossCheck = Long.valueOf(nx) * 100000 + Long.valueOf(checky);
					if (mp.containsKey(crossCheck)) {
						boolean[] cc = mp.get(crossCheck);
						if (cc[7])
							answer++;
					}
				} else if (arrows[i] == 7) {
					int checky = ny + 1;
					// System.out.println(nx+" "+ny);
					Long crossCheck = Long.valueOf(nx) * 100000 + Long.valueOf(checky);
					// System.out.println(crossCheck);
					if (mp.containsKey(crossCheck)) {
						boolean[] cc = mp.get(crossCheck);
						if (cc[5])
							answer++;
					}
				}
			}
			cx = nx;
			cy = ny;
			xy = Long.valueOf(cx) * 100000 + Long.valueOf(cy);

		}
		return answer;
	}
}
