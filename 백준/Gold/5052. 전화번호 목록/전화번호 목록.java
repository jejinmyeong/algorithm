import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        loop: for (int t = 0 ; t < T ; t++) {
            int N = Integer.parseInt(br.readLine());

            HashSet<String> set = new HashSet<>();
            for (int i = 0 ; i < N ; i++) {
                String number = br.readLine();
                set.add(number);
            }

            for (String s : set) {
                for (int i = 1 ; i < s.length() ; i++) {
                    if (set.contains(s.substring(0, i))) {
                        sb.append("NO").append("\n");
                        continue loop;
                    }
                }
            }

            sb.append("YES").append("\n");
        }

        System.out.print(sb);
    }
}