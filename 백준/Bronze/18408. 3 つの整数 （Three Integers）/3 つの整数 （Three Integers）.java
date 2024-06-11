import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int one = 0;
        int two = 0;

        for (int i = 0 ; i < 3 ; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (n == 1) {
                one++;
            } else {
                two++;
            }
        }
        
        System.out.println(one > two ? 1 : 2);
    }
}