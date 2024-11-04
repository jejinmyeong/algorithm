import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            if(arr[i] <= Integer.parseInt(st.nextToken())) {
                answer++;
            }
        }
        System.out.print(answer);
    }
}
