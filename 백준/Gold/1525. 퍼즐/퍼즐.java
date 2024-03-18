import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Node {
        String nums;
        int cnt;

        Node(String nums, int cnt) {
            this.nums = nums;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String nums = "";

        for (int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 3 ; j++) {
                nums += st.nextToken();
            }
        }

        HashSet<String> visited = new HashSet<>();

        String result = "123456780";

        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(nums, 0));
        visited.add(nums);

        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            int idx = now.nums.indexOf("0");

            int x = idx / 3;
            int y = idx % 3;

            if (result.equals(now.nums)) {
                System.out.println(now.cnt);
                return;
            }

            for (int d = 0 ; d < 4 ; d++) {
                int nx = x + D[d][0];
                int ny = y + D[d][1];

                if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;

                char temp = now.nums.charAt(nx * 3 + ny);

                String next = now.nums.replace(temp, '9');
                next = next.replace('0', temp);
                next = next.replace('9', '0');

                if (visited.contains(next)) {
                    continue;
                }

                visited.add(next);
                queue.offer(new Node(next, now.cnt + 1));
            }
        }

        System.out.println(-1);
    }
}