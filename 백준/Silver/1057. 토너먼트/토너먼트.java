import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int ans = 0;

        while (p1 != p2) {
            p1 = (p1 + 1) / 2;
            p2 = (p2 + 1) / 2;
            ans++;
        }

        System.out.println(ans);

    }
}