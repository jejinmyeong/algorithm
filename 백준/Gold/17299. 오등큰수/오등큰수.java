import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [] nums = new int[N];
        for (int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int [] cnt = new int[1000001];
        for (int i = 0 ; i < N ; i++) {
            cnt[nums[i]]++;
        }

        Stack<Integer> stack = new Stack<>();

        int [] result = new int[N];

        for (int i = 0 ; i < N ; i++) {
            if (stack.isEmpty()) stack.push(i);
            while (!stack.isEmpty() && cnt[nums[stack.peek()]] < cnt[nums[i]]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i = 0 ; i < N ; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

    }
}