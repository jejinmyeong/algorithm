package J2023Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_12100_2048Easy {
    static int [][] map;
    static int N;
    public static void main(String[] args) throws IOException {
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

    }

    static void backTracking (int dep, int [][] _map) {
        if (dep == 5) return;



    }
    // d => 0 위쪽 1 오른쪽 2 아래쪽 3 왼쪽
//    static int [][] move (int [][] _map, int d) {
//        int startX = d == 1 ? N - 1 : 0;
//        int startY = d == 2 ? N - 1 : 0;
//
//
//    }
}
