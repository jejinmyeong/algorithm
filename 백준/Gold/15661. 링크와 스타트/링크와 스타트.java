import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N, ans;
    static int [][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;

        for (int i = 1 ; i < ((1 << N) - 1) ; i++) {
            calc(i);
        }

        System.out.println(ans);
    }

    static void calc(int n) {
        List<Integer> link = new ArrayList<>();
        List<Integer> start = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            if ((n & (1 << i)) == 0) {
                link.add(i);
            } else {
                start.add(i);
            }
        }
        int score1 = 0;
        int score2 = 0;

        for (int i = 0 ; i < link.size() ; i++) {
            for (int j = 0 ; j < link.size() ; j++) {
                score1 += map[link.get(i)][link.get(j)];
            }
        }

        for (int i = 0 ; i < start.size() ; i++) {
            for (int j = 0 ; j < start.size() ; j++) {
                score2 += map[start.get(i)][start.get(j)];
            }
        }

        ans = Math.min(ans, Math.abs(score1 - score2));
    }
}