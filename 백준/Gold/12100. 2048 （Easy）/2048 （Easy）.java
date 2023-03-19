import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int [][] map;
    static int N, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, map);

        System.out.println(ans);
    }

    static void backTracking (int dep, int [][] _map) {
        if (dep == 5) {
            for (int i = 0 ; i < N ; i++) {
                for (int j = 0 ; j < N ; j++) {
                    ans = Math.max(ans, _map[i][j]);
                }
            }
            return;
        }

        for (int d = 0 ; d < 4 ; d++) {
            backTracking(dep + 1, move(_map, d));
        }

    }
    // d => 0 위쪽 1 오른쪽 2 아래쪽 3 왼쪽
    static int [][] move (int [][] _map, int d) {
        int [][] map = new int[N][N];

        if (d == 0) {
            for (int j = 0 ; j < N ; j++) {
                Stack<Integer> stack = new Stack<>();
                boolean flag = true;
                for (int i = 0 ; i < N ; i++) {
                    if (_map[i][j] != 0) {
                        if (stack.isEmpty() || stack.peek() != _map[i][j] || !flag) {
                            stack.push(_map[i][j]);
                            flag = true;
                        }
                        else {
                            stack.push(stack.pop() + _map[i][j]);
                            flag = false;
                        }
                    }
                }
                int idx = stack.size();
                while(!stack.isEmpty()) {
                    map[--idx][j] = stack.pop();
                }
            }
        } else if (d == 1) {
            for (int i = 0 ; i < N ; i++) {
                Stack<Integer> stack = new Stack<>();
                boolean flag = true;
                for (int j = N - 1 ; j >= 0 ; j--) {
                    if (_map[i][j] != 0) {
                        if (stack.isEmpty() || stack.peek() != _map[i][j] || !flag) {
                            stack.push(_map[i][j]);
                            flag = true;
                        }
                        else {
                            stack.push(stack.pop() + _map[i][j]);
                            flag = false;
                        }
                    }
                }
                int idx = stack.size();
                while(!stack.isEmpty()) {
                    map[i][N - idx--] = stack.pop();
                }
            }
        } else if (d == 2) {
            for (int j = 0 ; j < N ; j++) {
                Stack<Integer> stack = new Stack<>();
                boolean flag = true;
                for (int i = N - 1 ; i >= 0 ; i--) {
                    if (_map[i][j] != 0) {
                        if (stack.isEmpty() || stack.peek() != _map[i][j] || !flag) {
                            stack.push(_map[i][j]);
                            flag = true;
                        }
                        else {
                            stack.push(stack.pop() + _map[i][j]);
                            flag = false;
                        }
                    }
                }
                int idx = stack.size();
                while(!stack.isEmpty()) {
                    map[N - idx--][j] = stack.pop();
                }
            }
        } else {
            for (int i = 0 ; i < N ; i++) {
                Stack<Integer> stack = new Stack<>();
                boolean flag = true;
                for (int j = 0 ; j < N ; j++) {
                    if (_map[i][j] != 0) {
                        if (stack.isEmpty() || stack.peek() != _map[i][j] || !flag) {
                            stack.push(_map[i][j]);
                            flag = true;
                        }
                        else {
                            stack.push(stack.pop() + _map[i][j]);
                            flag = false;
                        }
                    }
                }
                int idx = stack.size();
                while(!stack.isEmpty()) {
                    map[i][--idx] = stack.pop();
                }
            }
        }

        return map;
    }
}

