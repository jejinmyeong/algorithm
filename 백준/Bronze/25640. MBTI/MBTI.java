import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mbti = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            if (mbti.equals(br.readLine())) cnt++;
        }

        System.out.println(cnt);
    }
}