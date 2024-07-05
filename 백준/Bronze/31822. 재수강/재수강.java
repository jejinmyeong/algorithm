import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine().substring(0, 5);

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        
        for (int i = 0 ; i < N ; i++) {
            String subject = br.readLine().substring(0, 5);

            if (code.equals(subject)) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
