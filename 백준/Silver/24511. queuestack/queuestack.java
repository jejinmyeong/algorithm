import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] A = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (A[i] == 0) {
                deque.offerLast(n);
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0 ; i < M ; i++) {
            int m = Integer.parseInt(st.nextToken());
            
            deque.offerFirst(m);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}