import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());

        double [] good = new double[N + 1];
        double [] bad = new double[N + 1];

        if (now == 1) {
            bad[0] = 1d;
        } else {
            good[0] = 1d;
        }

        st = new StringTokenizer(br.readLine());

        Double gg = Double.parseDouble(st.nextToken());
        Double gb = Double.parseDouble(st.nextToken());
        Double bg = Double.parseDouble(st.nextToken());
        Double bb = Double.parseDouble(st.nextToken());

        for (int i = 1 ; i <= N ; i++) {
            good[i] = good[i - 1] * gg + bad[i - 1] * bg;
            bad[i] = good[i - 1] * gb + bad[i - 1] * bb;
        }

        System.out.println(Math.round(good[N] * 1000));
        System.out.println(Math.round(bad[N] * 1000));
    }
}
