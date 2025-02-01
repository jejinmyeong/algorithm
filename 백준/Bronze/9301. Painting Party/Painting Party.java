import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1 ; t <= T ; t++) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            char [][] map = new char[n][n];

            for (int i = 0 ; i < n ; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 0 ; i < m ; i++) {
                st = new StringTokenizer(br.readLine());

                String type = st.nextToken();

                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int w = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);

                if ("Filled".equals(type)) {
                    for (int j = y ; j < y + h ; j++) {
                        for (int k = x ; k < x + w ; k++) {
                            map[j][k] = c;
                        }
                    }
                } else {
                    for (int j = y ; j < y + h ; j++) {
                        for (int k = x ; k < x + w ; k++) {
                            if (j == y || j == y + h - 1 || k == x || k == x + w - 1) {
                                map[j][k] = c;
                            }
                        }
                    }
                }
            }


            sb.append("Case ").append(t).append(":").append("\n");

            for (int i = n - 1 ; i >= 0 ; i--) {
                sb.append(new String(map[i])).append("\n");
            }
        }

        System.out.println(sb);
    }
}
