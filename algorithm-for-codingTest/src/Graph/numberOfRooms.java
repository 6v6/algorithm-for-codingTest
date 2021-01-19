package Graph;

import java.util.HashMap;

/* ���� ����
 * �Ф� �� ��ư� Ǯ����... �ڹ� ������ �̿��ؼ� üũ�Ϸ��� �ϴ�, x,y���� ������ ��� �����ؾ����� ����� �Ǵ�.
 * hashmap<Long, boolean> �迭�� ���¸� �̿�����.
 * key������ x*100000+y���� �־� x,y�� ���� �ϳ��� long������ ����ǵ��� �Ͽ���.
 * value������  x,y���� � �������� �̵��ߴ����� �����ϱ� ���� boolean �迭�� ����Ͽ���. ����(0~7)�� �ε��������� �Ͽ� �湮������ �ִٸ�  true�� üũ�Ͽ���.
 * 
 * �˰����� © ��, üũ�ؾ��ϴ� ���� 2����
 * ù��°, ���� �湮�� ���� �ִ��� üũ
 * �ι�°, ���� �湮������ �ִٸ� � �������� �湮�ߴ��� üũ
 * �ι�°�� ������ ��, ������ �޶� ������ �����ϰ� ����Ѵ�
 * ��, ������ġ -> ������ġ �� �̵��� ���� ������ġ<-������ġ�� �̵��� ���� ���������� �ľ��Ѵ�.
 * ����) 
 * 0,0���� 6�� �������� �̵��ϸ� ������ġ�� 0,-1�� �ȴ�.
 * 0,-1���� 2�� �������� �̵��ϸ� ������ġ�� 0,0�� �ȴ�.
 * ���� �� ���� ��� �� � �̵��� �߻��ϵ� ���� �����̱� ������ �ΰ��� ��� �߻��Ѱ����� üũ�Ѵ�.
 * 
 * �˰��� ���� ����
 * 1 �ʱ� ������ ���� ��ġ�� 0,0���� ����
 * 2 �������� �̵��� ���� �湮������ �ִ��� Ȯ���Ѵ�.
	  2-1 �湮������ �ִٸ� ������ �̵��ߴ� �������� Ȯ���Ѵ�.
	  2-1-1 ������ �̵��� ������ �ƴ϶�� ���� ��������� answer�� ������Ų��.
	  2-1-2 �̵��� ������ �밢���̶�� �밢�� ũ�ν��� �����ƴ��� Ȯ���Ѵ�. ũ�ν��� �����ƴٸ� answer������Ų��.
	  2-2 �湮������ ���ٸ� ���� �̵��� ���� �湮�� ������ üũ�ϰ� ������� �����Ѵ�.
	  2-2-1 �̵��� ������ �밢���̶�� �밢�� ũ�ν��� �����ƴ��� Ȯ���Ѵ�. ũ�ν��� �����ƴٸ� answer������Ų��.
 * 3 ���� x,y���� ���� ������ �����Ѵ�.
 * 4 �̵��� ��ŭ 2~3���� ������ �ݺ��Ѵ�.
 * 
 * �ٸ� ������� �ڵ带 ã�ƺ��� ���ڿ� ���·� �̵��� ��ġ��, ���� ������ ��찡 �ִµ� �̰� �ξ� �����ϰ� ������ �ڵ带 �ۼ��� �� �ִµ�!
 * �׸��� �밢�� üũ�� ��ó�� if������ üũ�ؼ� Ȯ���ϴ°� �ƴϰ� for���� �ι������� üũ�ϸ� ���� Ȯ�� ����! 
 * */
public class numberOfRooms {
	public int solution(int[] arrows) {
		int answer = 0;
		int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
		// ��, ����
		HashMap<Long, boolean[]> mp = new HashMap<>();

		// ���� ��ġ
		int cx = 0;
		int cy = 0;
		Long xy = Long.valueOf(cx) * 100000 + Long.valueOf(cy);
		boolean[] check = new boolean[8];
		mp.put(xy, check);

		for (int i = 0; i < arrows.length; i++) {
			// ���� ��ġ
			int nx = cx + dx[arrows[i]];
			int ny = cy + dy[arrows[i]];
			Long nxy = Long.valueOf(nx) * 100000 + Long.valueOf(ny);
			int narrow;
			if (arrows[i] < 4)
				narrow = arrows[i] + 4;
			else
				narrow = arrows[i] - 4;
			// ���� ��ġ�� �湮������ �ִ���
			if (mp.containsKey(nxy)) {
				boolean[] c = mp.get(xy);
				boolean[] nc = mp.get(nxy);
				// ���� �̵��� �ߴ� ������ �ƴ϶��
				if (!c[arrows[i]] && !nc[narrow]) {
					// System.out.println(nx +" "+ny);
					answer++;
					c[arrows[i]] = true;
					nc[narrow] = true;
					mp.put(xy, c);
					mp.put(nxy, nc);

					// �밢�� ũ�ν�
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

				// �湮�� ������ üũ
				boolean[] c = mp.get(xy);
				boolean[] nc = new boolean[8];
				c[arrows[i]] = true;
				nc[narrow] = true;
				mp.put(xy, c);
				mp.put(nxy, nc);
				
				// �밢�� ũ�ν�
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
