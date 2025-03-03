import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean [] isPrimeNumbers = new boolean[N + 1];

        Arrays.fill(isPrimeNumbers, true);

        isPrimeNumbers[0] = false;
        isPrimeNumbers[1] = false;

        for (int i = 2; i <= N; i++) {
            if (!isPrimeNumbers[i]) continue;
            for (int j = i + i ; j <= N ; j += i) isPrimeNumbers[j] = false;
        }

        Deque<Character> deque = new ArrayDeque<>();

        boolean flag = true;

        deque.offer('B');

        int B = 1;
        int S = 0;

        for (int i = 2; i <= N; i++) {
            if (isPrimeNumbers[i]) {
                if (flag) {
                    if (deque.peekLast() == 'B') {
                        deque.pollLast();
                        deque.offer('S');
                        B--;
                        S++;
                    }
                    deque.offer('S');
                    S++;
                    flag = false;
                } else {
                    if (deque.peek() == 'B') {
                        deque.poll();
                        deque.offerFirst('S');
                        B--;
                        S++;
                    }
                    deque.offerFirst('S');
                    S++;
                    flag = true;
                }
            } else {
                if (flag) deque.offer('B');
                else deque.offerFirst('B');
                B++;
            }
        }

        System.out.println(B + " " + S);
    }
}