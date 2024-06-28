import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            T -= Integer.parseInt(st.nextToken());
        }

        if (T > 0) {
            System.out.println("Padaeng_i Cry");
        } else {
            System.out.println("Padaeng_i Happy");
        }
    }
}