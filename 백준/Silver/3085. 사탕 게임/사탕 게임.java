import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static char [][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0 ; i < N ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        dfs();

        System.out.println(ans);
    }

    static void dfs() {
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                // 오른 쪽 또는 아래 쪽 사탕 선택
                if (i != N - 1 && map[i][j] != map[i + 1][j]) {
                    char temp = map[i][j];
                    map[i][j] = map[i + 1][j];
                    map[i + 1][j] = temp;
                    count();
                    map[i + 1][j] = map[i][j];
                    map[i][j] = temp;
                }

                if (j != N - 1 && map[i][j] != map[i][j + 1]) {
                    char temp = map[i][j];
                    map[i][j] = map[i][j + 1];
                    map[i][j + 1] = temp;
                    count();
                    map[i][j + 1] = map[i][j];
                    map[i][j] = temp;
                }
            }
        }
    }

    static void count() {
        int cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            int nr = map[i][0];
            int nrTemp = 1;
            int nc = map[0][i];
            int ncTemp = 1;
            for (int j = 1 ; j < N ; j++) {
                if (map[i][j] == nr) {
                    nrTemp++;
                } else {
                    nr = map[i][j];
                    nrTemp = 1;
                }

                if (map[j][i] == nc) {
                    ncTemp++;
                } else {
                    nc = map[j][i];
                    ncTemp = 1;
                }

                cnt = Math.max(cnt, nrTemp);
                cnt = Math.max(cnt, ncTemp);
            }
        }

        ans = Math.max(ans, cnt);
    }
}