import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        if (!input.contains("0")) {
            System.out.println(-1);
            return;
        }

        int total = 0;
        int [] cnt = new int[10];
        for (int i = 0 ; i < input.length() ; i++) {
            int n = input.charAt(i) - '0';
            cnt[n]++;
            total += n;
        }

        if (total % 3 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 9 ; i >= 0 ; i--) {
            for (int j = 0 ; j < cnt[i] ; j++) {
                sb.append(i);
            }
        }

        System.out.println(sb);
    }
}