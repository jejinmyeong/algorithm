import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean [][] map = new boolean[N][N];
        for (int i = 0 ; i < N ; i++) {
            String info = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                if (info.charAt(j) == '.') map[i][j] = true;
            }
        }

        int w = 0;
        int h = 0;
        for (int i = 0 ; i < N ; i++) {
            int wt = 0;
            int ht = 0;
            for (int j = 0 ; j < N ; j++) {
                if (!map[i][j] || j == N - 1) {
                    if (map[i][j]) wt++;
                    if (wt >= 2) w++;
                    wt = 0;
                } else wt++;

                if (!map[j][i] || j == N - 1) {
                    if (map[j][i]) ht++;
                    if (ht >= 2) h++;
                    ht = 0;
                } else ht++;
            }
        }

        System.out.println(w + " " + h);
    }
}