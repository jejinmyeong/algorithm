import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = null;

        int cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            String chat = br.readLine();

            if ("ENTER".equals(chat)) {
                set = new HashSet<>();
                continue;
            }

            if (!set.contains(chat)) {
                set.add(chat);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}