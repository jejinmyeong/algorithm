package J2023Mar;

import java.io.*;
import java.util.*;

public class Main_boj_2325_오븐시계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int A = Integer.parseInt(br.readLine());

        int temp = (M + A) / 60;
        M = (M + A) % 60;

        H = (H + temp) % 24;

        System.out.println(H + " " + M);
    }
}