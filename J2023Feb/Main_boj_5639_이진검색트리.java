package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_5639_이진검색트리 {
    static class Node {
        int n;
        Node l, r;
        Node (int n) {
            this.n = n;
        }

        public void add (int n) {
            if (n < this.n) {
                if (this.l == null) this.l = new Node(n);
                else this.l.add(n);
            } else {
                if (this.r == null) this.r = new Node(n);
                else this.r.add(n);
            }
        }

    }
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String input = br.readLine();

            if ("".equals(input) || input == null) break;

            root.add(Integer.parseInt(input));
        }

        postOrder(root);

        System.out.print(sb);
    }

    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.l);
        postOrder(node.r);

        sb.append(node.n).append("\n");
    }
}
