import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = 0;

        while (st.hasMoreTokens()) {
            S += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int T = 0;

        while (st.hasMoreTokens()) {
            T += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(S, T));
    }
}