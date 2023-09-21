import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int per = (int) Math.round(N * 0.15);

        Arrays.sort(arr);

        int sum = 0;

        for (int i = per ; i < N - per ; i++) {
            sum += arr[i];
        }

        System.out.println((int) Math.round(sum / (double)(N - per * 2)));
        
    }
}
