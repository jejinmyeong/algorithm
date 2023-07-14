import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] matrix1 = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                matrix1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        int [][] matrix2 = new int[M][K];

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < K ; j++) {
                matrix2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] ans = new int[N][K];

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < K ; j++) {
                for (int k = 0 ; k < M ; k++) {
                    ans[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < K ; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}