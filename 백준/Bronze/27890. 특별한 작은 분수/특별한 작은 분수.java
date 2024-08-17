import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < N ; i++) {
            if (X % 2 ==0) X = (X / 2) ^ 6;
            else X = (X * 2) ^ 6;
        }

        System.out.println(X);

    }
}
