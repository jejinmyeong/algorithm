package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_2908_상수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char [] c1 = st.nextToken().toCharArray();
        String s1 = "";
        for (int i = c1.length - 1 ; i >= 0 ; i--) {
            s1 += c1[i];
        }
        char [] c2 = st.nextToken().toCharArray();
        String s2 = "";
        for (int i = c2.length - 1 ; i >= 0 ; i--) {
            s2 += c2[i];
        }

        System.out.println(Math.max(Integer.parseInt(s1), Integer.parseInt(s2)));
    }
}
