import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        long remain = 0;

        for (int i = 0 ; i < N.length() ; i++) {
            remain = (remain * 10 + (N.charAt(i) - '0')) % 20000303;
        }

        System.out.println(remain);
    }
}
