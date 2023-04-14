import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int cnt = 1;

        for (int i = 1 ; i < input.length() ; i++) {
            if (input.charAt(i - 1) != input.charAt(i)) cnt++;
        }

        System.out.println(cnt / 2);
    }
}