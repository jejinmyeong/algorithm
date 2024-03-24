import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                StringBuilder temp = new StringBuilder();

                String word = st.nextToken();
                sb.append(temp.append(word).reverse()).append(" ");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}