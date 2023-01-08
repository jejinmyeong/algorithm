package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_1987_알파벳 {
	static int R, C;
	static char[][] map;
	static int[][] d = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // 상 하 좌 우
	static int ans;
	static boolean[] visit = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		// 좌측 상단에서 이동할 수 있는 경우 하, 우
		ans = 0;
		visit[map[0][0] - 'A'] = true;
		move(0, 0, 1);
		System.out.println(ans);

	}

	static void move(int x, int y, int sum) {

		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if (nx < 0 || nx >= C || ny < 0 || ny >= R)
				continue;
			if (visit[map[ny][nx] - 'A'])
				continue;
			visit[map[ny][nx] - 'A'] = true;
			move(nx, ny, sum + 1);
			visit[map[ny][nx] - 'A'] = false;

		}

		if (ans < sum)
			ans = sum;
		return;
	}
}
