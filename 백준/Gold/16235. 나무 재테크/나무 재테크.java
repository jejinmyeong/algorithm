import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static ArrayList<Integer> [][] trees;
    static int [][] A, map, D = {{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1},{-1, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                map[i][j] = 5;
            }
        }
        trees = new ArrayList[N + 1][N + 1];

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                trees[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= N ; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            trees[x][y].add(z);
        }

        dfs(0);

        int ans = 0;

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                ans += trees[i][j].size();
            }
        }

        System.out.println(ans);
    }

    static void dfs(int k) {
        if (k == K) return;
        ArrayList<Integer> [][] _trees = new ArrayList[N + 1][N + 1];

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                _trees[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                Collections.sort(trees[i][j]);
                int nourish = 0;
                for (int t = 0 ; t < trees[i][j].size() ; t++) {
                    int now = trees[i][j].get(t);
                    if (map[i][j] < now) {
                        nourish += now / 2;
                    } else {
                        _trees[i][j].add(now + 1);
                        map[i][j] -= now;
                    }
                }
                map[i][j] += nourish;

                for (int t = 0 ; t < _trees[i][j].size() ; t++) {
                    int now = _trees[i][j].get(t);
                    if (now % 5 == 0) {
                        for (int d = 0 ; d < 8 ; d++) {
                            int nx = i + D[d][0];
                            int ny = j + D[d][1];

                            if (isOverflow(nx, ny)) continue;

                            _trees[nx][ny].add(1);
                        }
                    }
                }
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                map[i][j] += A[i][j];
            }
        }

        trees = _trees;
        dfs(k + 1);
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 1 || ny < 1 || nx > N || ny > N;
    }
}