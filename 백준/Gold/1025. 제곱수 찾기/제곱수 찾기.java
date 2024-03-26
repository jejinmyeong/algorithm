import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int ans = -1;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                for (int n = -N ; n < N ; ++n) {
                    for(int m = -M ; m < M ; ++m) {
                        if (n == 0 && m == 0) {
                            continue;
                        }

                        int t = 0;
                        int ni = i;
                        int nj = j;
                        while (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                            t = 10 * t + map[ni][nj];

                            if (Math.abs(Math.sqrt(t) - (int) Math.sqrt(t)) < 1e-10) {
                                ans = Math.max(ans, t);
                            }

                            ni += n;
                            nj += m;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}