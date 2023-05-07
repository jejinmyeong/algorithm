import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][][] calendar = new int[15][28][19];

        int day = 1;

        for (int i = 0 ; i < 15 * 28 * 19 ; i++) {
            calendar[i % 15][i % 28][i % 19] = day++;
        }

        System.out.println(calendar[E - 1][S - 1][M - 1]);
    }
}
