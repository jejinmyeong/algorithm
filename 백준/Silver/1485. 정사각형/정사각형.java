import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int [] x = new int[4];
            int [] y = new int[4];
            for (int i = 0 ; i < 4 ; i++) {
                st = new StringTokenizer(br.readLine());

                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }
            
            double [] len = new double[6];
            
            int idx = 0;
            
            for (int i = 0 ; i < 3 ; i++) {
                for (int j = i + 1 ; j < 4 ; j++) {
                    len[idx++] = Math.pow(x[j] - x[i], 2) + Math.pow(y[j] - y[i], 2);
                }
            }
            
            Arrays.sort(len);
            
            if (len[0] == len[1] && len[0] == len[2] && len[0] == len[3] && len[4] == len[5]) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}