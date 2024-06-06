import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0 ; i < 5 ; i++) {
            int s = Integer.parseInt(br.readLine());
            if (set.contains(s)) {
                set.remove(s);
            } else {
                set.add(s);
            }
        }

        System.out.println(set.toArray()[0]);
    }
}