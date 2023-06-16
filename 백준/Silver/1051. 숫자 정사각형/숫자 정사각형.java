import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int max = Math.min(N, M);

        while (max > 1) {
            for (int i = 0 ; i <= N - max ; i++) {
                for (int j = 0 ; j <= M - max ; j++) {
                    if (map[i][j] == map[i + max - 1][j] &&
                        map[i][j] == map[i][j + max - 1] &&
                        map[i][j] == map[i + max - 1][j + max - 1]) {
                        System.out.println(max * max);
                        return;
                    }
                }
            }
            max--;
        }

        System.out.println(1);
    }
}