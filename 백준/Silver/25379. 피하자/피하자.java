import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 한 쪽에는 모두 짝수 한 쪽에는 모두 홀수가 되도록 정렬하는 최소 횟수

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        if (even.size() == 0 || odd.size() == 0) {
            System.out.println(0);
            return;
        }

        int cnt = 0;

        // 짝수를 왼쪽에 정렬하는 방법
        int start = odd.get(0);
        int temp = 0;
        for (int i = 0 ; i < even.size() ; i++) {
            if (even.get(i) < start) continue;

            temp += even.get(i) - start;
            start++;
        }

        cnt = temp;

        start = even.get(0);
        temp = 0;
        for (int i = 0 ; i < odd.size() ; i++) {
            if (odd.get(i) < start) continue;

            temp += odd.get(i) - start;
            start++;
        }

        cnt = Math.min(cnt, temp);

        System.out.println(cnt);
    }
}