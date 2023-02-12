package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_2920_음계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int init = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i < 8 ; i++) {
            int s = Integer.parseInt(st.nextToken());
            if (Math.abs(s - init) != i) {
                System.out.println("mixed");
                return;
            }
        }

        System.out.println(init == 1 ? "ascending" : "descending");
    }
}
