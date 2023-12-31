import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        int [][] map = new int[R][C];

        int K = Integer.parseInt(br.readLine());

        if (R * C < K) {
            System.out.println(0);
            return;
        }

        int x = R - 1;
        int y = 0;
        int k = 1;
        int d = 0;

        while(k < K) {
            map[x][y] = k++;
            int nx = x + D[d][0];
            int ny = y + D[d][1];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != 0) {
                d = (d + 1) % 4;
            }

            x += D[d][0];
            y += D[d][1];
        }

        System.out.println((y + 1) + " " + (R - x));
    }
}
