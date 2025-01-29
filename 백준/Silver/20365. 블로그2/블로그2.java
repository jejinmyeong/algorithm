import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String colors = br.readLine();

        // 처음에 싹다 파란색으로 칠하는 경우
        int blue = 1;

        if (colors.charAt(0) == 'R') blue++;

        for (int i = 1 ; i < N ; i++) {
            if (colors.charAt(i) == 'R' && colors.charAt(i - 1) != 'R') {
                blue++;
            }
        }

        // 처음에 싹다 빨간색으로 칠하는 경우
        int red = 1;

        if (colors.charAt(0) == 'B') red++;

        for (int i = 1 ; i < N ; i++) {
            if (colors.charAt(i) == 'B' && colors.charAt(i - 1) != 'B') {
                red++;
            }
        }

        System.out.println(Math.min(blue, red));

    }
}
