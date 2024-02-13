import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String [] students = new String[N];

        for (int i = 0 ; i < N ; i++) {
            students[i] = br.readLine();
        }

        int ans = 0;

        loop: for (int i = 1 ; i <= students[0].length() ; i++) {
            Set<String> set = new HashSet<>();

            for (int j = 0 ; j < N ; j++) {
                String now = students[j].substring(students[j].length() - i);

                if (set.contains(now)) {
                    continue loop;
                } else {
                    set.add(now);
                }
            }

            ans = i;
            break;
        }

        System.out.println(ans);

    }
}