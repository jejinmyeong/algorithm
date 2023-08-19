import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(br.readLine());

        int ans = 0;

        while(st.hasMoreTokens()) {
            if (Integer.parseInt(st.nextToken()) == V) ans++;
        }

        System.out.println(ans);
    }
}
