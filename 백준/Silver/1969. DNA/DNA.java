import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] count = new int[M][4];

        for (int i = 0 ; i < N ; i++) {
            String DNA = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                if (DNA.charAt(j) == 'A') count[j][0]++;
                else if (DNA.charAt(j) == 'C') count[j][1]++;
                else if (DNA.charAt(j) == 'G') count[j][2]++;
                else if (DNA.charAt(j) == 'T') count[j][3]++;
            }
        }

        int HammingDistance = 0;

        for (int i = 0 ; i < M ; i++) {
            int idx = 0;
            int max = 0;
            for (int j = 0 ; j < 4 ; j++) {
                if (count[i][j] > max) {
                    idx = j;
                    max = count[i][j];
                }
            }
            HammingDistance += N - max;
            if (idx == 0) sb.append("A");
            else if (idx == 1) sb.append("C");
            else if (idx == 2) sb.append("G");
            else if (idx == 3) sb.append("T");
        }

        System.out.println(sb);
        System.out.println(HammingDistance);
    }
}
