import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static class Node {
        int parent, idx, left, right;

        Node(int idx, int left, int right) {
            this.parent = -1;
            this.idx = idx;
            this.left = left;
            this.right = right;
        }
    }
    static int N, depth, now;
    static Node [] trees;
    static int [] min, max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        trees = new Node[N + 1];
        min = new int[N + 1];
        max = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            trees[i] = new Node(i, -1, -1);
            min[i] = N;
            max[i] = 0;
        }

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            trees[idx].left = left;
            trees[idx].right = right;
            if (left != -1) trees[left].parent = idx;
            if (right != -1) trees[right].parent = idx;
        }

        int root = -1;

        for (int i = 1 ; i <= N ; i++) {
            if (trees[i].parent == -1) {
                root = i;
                break;
            }
        }

        now = 1;

        dfs(root, 1);

        int ans = 1;
        int width = max[1] - min[1] + 1;

        for (int i = 1 ; i <= depth ; i++) {
            int temp = max[i] - min[i] + 1;

            if (width < temp) {
                ans = i;
                width = temp;
            }
        }

        System.out.println(ans + " " + width);
    }

    static void dfs(int idx, int level) {
        Node root = trees[idx];
        if (depth < level) depth = level;
        
        if (root.left != -1) dfs(root.left, level + 1);
        
        min[level] = Math.min(min[level], now);
        max[level] = now++;
        
        if (root.right != -1) dfs(root.right, level + 1);
    }
}