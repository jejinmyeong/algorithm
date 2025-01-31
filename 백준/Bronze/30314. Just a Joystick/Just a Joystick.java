import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char [] before = br.readLine().toCharArray();
        char [] after = br.readLine().toCharArray();

        int ans = 0;

        for (int i = 0 ; i < n ; i++) {
            int move = Math.abs((int) before[i] - (int) after[i]);

            ans += Math.min(26 - move, move);
        }

        System.out.println(ans);
    }
}
