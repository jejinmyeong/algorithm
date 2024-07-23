import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [] arr = new int[5];

        for (int i = 0 ; i < 5 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0 ; i < 5 ; i++) {
            if (arr[i] == T) cnt++;
        }

        System.out.println(cnt);
    }
}