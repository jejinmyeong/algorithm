import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static int [][] map;
    static int [] papers;
    static int ans, amount;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[10][10];

        for (int i = 0 ; i < 10 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 10 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) amount++;
            }
        }
        ans = 25;
        papers = new int[] {0, 5, 5, 5, 5, 5};

        dfs(0, 0);
        System.out.println(ans == 25 ? -1 : ans);
    }

    static void dfs(int cnt, int r) {
        if (cnt >= ans) return;

        if (r == amount) {
            ans = Math.min(ans, cnt);
            return;
        }

        for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                if (map[i][j] == 0) continue;

                for (int k = 1 ; k <= 5 ; k++) {
                    if (papers[k] == 0) continue;
                    if (i + k > 10 || j + k > 10) return;

                    int temp = 0;
                    for(int m = i ; m < i + k ; m++) {
                        for (int n = j ; n < j + k ; n++) {
                            if (map[m][n] == 1) temp++;
                        }
                    }

                    if (temp != k * k) return;

                    for (int m = i ; m < i + k ; m++) {
                        for (int n = j ; n < j + k ; n++) {
                            map[m][n] = 0;
                        }
                    }

                    papers[k] -= 1;
                    dfs(cnt + 1, r + k * k);
                    papers[k] += 1;

                    for (int m = i ; m < i + k ; m++) {
                        for (int n = j ; n < j + k ; n++) {
                            map[m][n] = 1;
                        }
                    }
                }
            }
        }
    }
}
