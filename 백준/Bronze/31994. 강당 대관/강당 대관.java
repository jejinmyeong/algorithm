import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String ans = "";
        int max = 0;
        for (int i = 0 ; i < 7 ; i++) {
            st = new StringTokenizer(br.readLine());

            String seminar = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            if (n > max) {
                ans = seminar;
                max = n;
            }
        }

        System.out.println(ans);

    }
}
