import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = 15;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                String word = st.nextToken();

                if ("w".equals(word)) {
                    System.out.println("chunbae");
                    return;
                } else if ("b".equals(word)) {
                    System.out.println("nabi");
                    return;
                } else if ("g".equals(word)) {
                    System.out.println("yeongcheol");
                    return;
                }
            }
        }
    }
}