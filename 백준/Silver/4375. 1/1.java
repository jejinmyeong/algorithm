import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();


        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int ans = 1;
            int cnt = 1;

            while ((ans = ans % n) != 0) {
                cnt++;
                ans = ans*10 + 1;
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}