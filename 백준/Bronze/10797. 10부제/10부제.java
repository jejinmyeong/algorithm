import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int ans = 0;

        while(st.hasMoreTokens()) {
            if (N == Integer.parseInt(st.nextToken())) ans++;
        }

        System.out.println(ans);
    }
}