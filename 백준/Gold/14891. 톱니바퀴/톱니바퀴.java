import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [][] wheels = new int[5][8];

        for (int i = 1 ; i <= 4 ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < 8 ; j++) {
                wheels[i][j] = input.charAt(j) - '0';
            }
        }

        int [] N = new int[5];

        int K = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int [] temp = Arrays.copyOf(N, 5);

            for (int j = idx ; j < 4 ; j++) {
                if (wheels[j][(temp[j] + 2) % 8] != wheels[j + 1][(temp[j + 1] + 6) % 8]) {
                    N[j + 1] = (N[j + 1] + 8 + d * ((j - idx) % 2 == 0 ? 1 : -1)) % 8;
                } else {
                    break;
                }
            }

            for (int j = idx ; j > 0 ; j--) {
                if (wheels[j][(temp[j] + 6) % 8] != wheels[j - 1][(temp[j - 1] + 2) % 8]) {
                    N[j - 1] = (N[j - 1] + 8 + d * ((idx - j) % 2 == 0 ? 1 : -1)) % 8;
                } else {
                    break;
                }
            }
            N[idx] = (N[idx] + 8 + d * -1) % 8;
        }

        int ans = 0;

        for (int i = 1 ; i <= 4 ; i++) {
            if (wheels[i][N[i]] == 1) ans += (int) Math.pow(2, i - 1);
        }

        System.out.println(ans);

    }
}
