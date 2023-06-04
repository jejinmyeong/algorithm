import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] matrix1 = new int[N][M];
        int [][] matrix2 = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                matrix1[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0 ; i < N ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                matrix2[i][j] = input.charAt(j) - '0';
            }
        }

        int ans = 0;

        for (int i = 0 ; i < N - 2 ; i++) {
            for (int j = 0 ; j < M - 2 ; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    ans++;

                    for (int k = 0 ; k < 3 ; k++) {
                        for (int l = 0 ; l < 3 ; l++) {
                            matrix1[i + k][j + l] = (matrix1[i + k][j + l] + 1) % 2;
                        }
                    }
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans);
    }
}