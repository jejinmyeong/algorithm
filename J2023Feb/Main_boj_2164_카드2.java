package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_boj_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1 ; i <= N ; i++) {
            deque.add(i);
        }

        while (deque.size() != 1) {
            deque.pop();
            deque.add(deque.pollFirst());
        }

        System.out.println(deque.pop());
    }
}
