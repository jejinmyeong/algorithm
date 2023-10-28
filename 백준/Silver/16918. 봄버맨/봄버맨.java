import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char [][] map = new char[R][C];
        int [][] time = new int[R][C];

        for (int i = 0 ; i < R ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < C ; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'O') {
                    time[i][j] = 3;
                }
            }
        }

        int t = 0;
        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        while (t++ < N) {
            if (t % 2 == 0) {
                for (int i = 0 ; i < R ; i++) {
                    for (int j = 0 ; j < C ; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            time[i][j] = t + 3;
                        }
                    }
                }
            }else if (t % 2 == 1) {
                for (int i = 0 ; i < R ; i++) {
                    for (int j = 0 ; j < C ; j++) {
                        if (time[i][j] == t) {
                            map[i][j] = '.';
                            for (int d = 0 ; d < 4 ; d++) {
                                int nx = i + D[d][0];
                                int ny = j + D[d][1];

                                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                                if (map[nx][ny] == 'O' && time[nx][ny] != t) {
                                    map[nx][ny] = '.';
                                    time[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0 ; i < R ; i++) {
            sb.append(map[i]).append("\n");
        }
        System.out.println(sb);
    }
}
