import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int cnt = 0;

        for (int i = 0 ; i < input.length() - 3 ; i++) {
            if ("DKSH".equals(input.substring(i, i + 4))) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}