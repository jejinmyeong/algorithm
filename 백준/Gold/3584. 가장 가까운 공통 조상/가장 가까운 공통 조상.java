import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static class Node {
        int num, deps;
        Node parent;

        Node(int num) {
            this.num = num;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int getDeps() {
            if (parent == null) return this.deps = 0;
            if (this.deps != 0) return this.deps;
            return this.deps = parent.getDeps() + 1;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            Node [] nodes = new Node[N + 1];

            for (int i = 0 ; i <= N ; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0 ; i < N - 1 ; i++) {
                st = new StringTokenizer(br.readLine());

                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                nodes[child].setParent(nodes[parent]);
            }

            st = new StringTokenizer(br.readLine());

            Node node1 = nodes[Integer.parseInt(st.nextToken())];
            Node node2 = nodes[Integer.parseInt(st.nextToken())];

            while (node1 != node2) {
                int deps1 = node1.getDeps();
                int deps2 = node2.getDeps();

                if (deps1 <= deps2) {
                    node2 = node2.parent;
                }

                if (deps1 >= deps2) {
                    node1 = node1.parent;
                }
            }

            sb.append(node1.num).append("\n");
        }

        System.out.print(sb);
    }
}