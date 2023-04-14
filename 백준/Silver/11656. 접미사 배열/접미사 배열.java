import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        String [] res = new String[input.length()];
        for (int i = 0 ; i < input.length() ; i++) {
            res[i] = input.substring(i);
        }

        Arrays.sort(res);

        for (String s: res) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}