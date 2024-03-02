import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] cnt = new int[26];

        for (int i = 0 ; i < N ; i++) {
            char first = br.readLine().charAt(0);

            cnt[first - 'a']++;
        }

        for (int i = 0 ; i < 26 ; i++) {
            if (cnt[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }

        System.out.println(sb.length() == 0 ? "PREDAJA" : sb);
    }
}