package J2023Mar;

import java.io.*;
import java.util.*;

public class Main_boj_1712_손익분기점 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken()) - B;

        if (C <= 0) {
            System.out.println(-1);
        } else {
            System.out.println(A/C + 1);
        }
    }
}
