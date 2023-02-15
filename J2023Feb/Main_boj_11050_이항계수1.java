package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_11050_이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [][] map = new int[11][11];

        map[0][0] = 1;

        for (int i = 1 ; i <= 10 ; i++) {
            map[i][0] = 1;
            for (int j = 1 ; j <= i ; j++) {
                map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
            }
            map[i][i] = 1;
        }

        System.out.println(map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
    }
}
