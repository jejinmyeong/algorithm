import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = l ; i <= r ; i++) {
            if (min > Math.abs(x - i)) {
                min = Math.abs(x - i);
                res = i;
            }
        }

        System.out.println(res);
    }
}
