import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        TreeMap<String, Integer> woods = new TreeMap<>((s1, s2) -> s1.compareTo(s2));

        int cnt = 0;

        String input;
        while ((input = br.readLine()) != null) {
            cnt++;
            if (woods.containsKey(input)) woods.put(input, woods.get(input) + 1);
            else woods.put(input, 1);
        }

        for (String name: woods.keySet()) {
            sb.append(name).append(" ").append(String.format("%.4f", (double)woods.get(name) / cnt * 100)).append("\n");
        }

        System.out.println(sb);

    }
}