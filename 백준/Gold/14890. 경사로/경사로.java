import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        // 가로로 갈 수 있는 길
        loop: for (int i = 0 ; i < N ; i++) {
            boolean flag = false;
            int cnt = 1;
            for (int j = 1 ; j < N ; j++) {
                // 이전 높이와 현재 높이의 차이가 2이상인 경우 || 현재 높이의 연속된 길의 수가 L이하인데 높은 길이 나온 경우 || 이전에 경사로를 놓지 못했는데 다시 낮은 길이 나온 경우
                if (Math.abs(map[i][j] - map[i][j - 1]) > 1 || (cnt < L && map[i][j] > map[i][j - 1]) || (flag && map[i][j] < map[i][j - 1])) continue loop;
                // 현재 높이의 연속된 길의 수가 L이상인데 높은 길이 나온 경우
                if (map[i][j] > map[i][j - 1]) {
                    cnt = 1;
                }
                else if (map[i][j] < map[i][j - 1]) {
                    flag = true;
                    cnt = 1;
                }
                // 현재 높이와 이전의 높이가 같은 경우
                else cnt++;

                if (flag && cnt >= L) {
                    flag = false;
                    cnt -= L;
                }
            }

            if (!flag) ans++;
        }

        loop: for (int j = 0 ; j < N ; j++) {
            boolean flag = false;
            int cnt = 1;
            for (int i = 1 ; i < N ; i++) {
                // 이전 높이와 현재 높이의 차이가 2이상인 경우 || 현재 높이의 연속된 길의 수가 L이하인데 높은 길이 나온 경우 || 이전에 경사로를 놓지 못했는데 다시 낮은 길이 나온 경우
                if (Math.abs(map[i][j] - map[i - 1][j]) > 1 || (cnt < L && map[i][j] > map[i - 1][j]) || (flag && map[i][j] < map[i - 1][j])) continue loop;
                // 현재 높이의 연속된 길의 수가 L이상인데 높은 길이 나온 경우
                if (map[i][j] > map[i - 1][j]) {
                    cnt = 1;
                }
                else if (map[i][j] < map[i - 1][j]) {
                    flag = true;
                    cnt = 1;
                }
                // 현재 높이와 이전의 높이가 같은 경우
                else cnt++;

                if (flag && cnt >= L) {
                    flag = false;
                    cnt -= L;
                }
            }

            if (!flag) ans++;
        }

        System.out.println(ans);
    }
}
