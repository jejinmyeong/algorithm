import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int ans = 0;
        
        for (int i = 0 ; i < N ; i++) {
            int a = Integer.parseInt(br.readLine());
            ans += a;
        }

        System.out.println(ans);
    }
}
