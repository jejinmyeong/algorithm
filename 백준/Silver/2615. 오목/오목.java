import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [][] map = new int[20][20];

        for (int i = 1 ; i < 20 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j < 20 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1 ; i < 20 ; i++) {
            for (int j = 1 ; j < 20 ; j++) {
                if (map[i][j] == 0) continue;

                // 가로
                if (
                        j <= 15 &&
                        map[i][j] == map[i][j + 1] &&
                        map[i][j] == map[i][j + 2] &&
                        map[i][j] == map[i][j + 3] &&
                        map[i][j] == map[i][j + 4] &&
                        (j == 1 || (j != 1 && map[i][j] != map[i][j - 1])) &&
                        (j == 15 || (j != 15 && map[i][j] != map[i][j + 5]))
                ) {
                    System.out.println(map[i][j]);
                    System.out.println(i + " " + j);
                    return;
                }

                // 우하방 대각선
                else if (
                        i <= 15 && j <= 15 &&
                        map[i][j] == map[i + 1][j + 1] &&
                        map[i][j] == map[i + 2][j + 2] &&
                        map[i][j] == map[i + 3][j + 3] &&
                        map[i][j] == map[i + 4][j + 4] &&
                        (j == 1 || i == 1 || (j != 1 && i != 1 && map[i][j] != map[i - 1][j - 1])) &&
                        (j == 15 || i == 15 || (j != 15 && i != 15 && map[i][j] != map[i + 5][j + 5]))
                ) {
                    System.out.println(map[i][j]);
                    System.out.println(i + " " + j);
                    return;
                }

                // 세로로
                else if (
                        i <= 15 &&
                        map[i][j] == map[i + 1][j] &&
                        map[i][j] == map[i + 2][j] &&
                        map[i][j] == map[i + 3][j] &&
                        map[i][j] == map[i + 4][j] &&
                        (i == 1 || (i != 1 && map[i][j] != map[i - 1][j])) &&
                        (i == 15 || (i != 15 && map[i][j] != map[i + 5][j]))
                ) {
                    System.out.println(map[i][j]);
                    System.out.println(i + " " + j);
                    return;
                }

                // 좌하방 대각선
                if (
                        j >= 5 && i <= 15 &&
                        map[i][j] == map[i + 1][j - 1] &&
                        map[i][j] == map[i + 2][j - 2] &&
                        map[i][j] == map[i + 3][j - 3] &&
                        map[i][j] == map[i + 4][j - 4] &&
                        (i == 1 || j == 19 || (i != 1 && j != 19 && map[i][j] != map[i - 1][j + 1])) &&
                        (i == 15 || j == 5 || (i != 15 && j != 5 && map[i][j] != map[i + 5][j - 5]))
                ) {
                    System.out.println(map[i][j]);
                    System.out.println((i + 4) + " " + (j - 4));
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
