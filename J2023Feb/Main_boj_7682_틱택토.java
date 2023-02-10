package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_7682_틱택토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if ("end".equals(input)) {
                break;
            }

            char [][] map = new char[3][3];

            int X = 0;
            int O = 0;

            for (int i = 0 ; i < 3 ; i++) {
                for (int j = 0 ; j < 3; j++) {
                    map[i][j] = input.charAt(i * 3 + j);
                    if (map[i][j] == 'X') X++;
                    else if (map[i][j] == 'O') O++;
                }
            }

            boolean [] res = ticTakToe(map);

            // 마지막에 X가 돌을 놓은 경우
            if (X - 1 == O) {
                // O가 이겼으면 invalid
                if (res[1]) sb.append("invalid").append("\n");
                    // X가 이겼거나 맵을 가득 채우고 아무도 못이겼으면 valid
                else if (res[0] || X + O == 9) sb.append("valid").append("\n");
                else sb.append("invalid").append("\n");
                continue;
            }
            // 마지막에 O가 돌을 놓은 경우
            else if (X == O) {
                // X가 이겼으면 invalid
                if (res[0]) sb.append("invalid").append("\n");
                    // O가 이겼으면 valid
                else if (res[1]) sb.append("valid").append("\n");
                else sb.append("invalid").append("\n");
                continue;
            }
            // 위 조건을 만족하지 못한경우
            sb.append("invalid").append("\n");

        }

        System.out.print(sb);
    }

    static boolean [] ticTakToe (char [][] map) {
        boolean isXWin = false;
        boolean isOWin = false;
        // 가로, 세로
        for (int i = 0 ; i < 3 ; i++) {
            if (map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                if (map[i][0] == 'X') isXWin = true;
                if (map[i][0] == 'O') isOWin = true;
            }

            if (map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                if (map[0][i] == 'X') isXWin = true;
                if (map[0][i] == 'O') isOWin = true;
            }
        }

        // 대각선
        if ((map[0][0] == map[1][1] && map[1][1] == map[2][2]) || map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
            if (map[1][1] == 'X') isXWin = true;
            else if (map[1][1] == 'O') isOWin = true;
        }

        return new boolean[] {isXWin, isOWin};
    }
}
