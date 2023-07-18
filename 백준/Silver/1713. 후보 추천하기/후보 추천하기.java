import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Student implements Comparable<Student> {
        int num, cnt, time;
        Student (int num, int cnt, int time) {
            this.num = num;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if (this.cnt == o.cnt) return this.time - o.time;
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        HashMap<Integer, Student> map = new HashMap<>();
        PriorityQueue<Student> queue = new PriorityQueue<>();

        for (int i = 0 ; i < M ; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (map.containsKey(num)) {
                Student now = map.get(num);
                queue.remove(now);
                now.cnt++;
                queue.offer(now);
            }
            else {
                Student student = new Student(num, 1, i);
                if (map.size() >= N) {
                    Student target = queue.poll();
                    map.remove(target.num);
                }

                map.put(num, student);
                queue.offer(student);
            }
        }

        PriorityQueue<Integer> ans = new PriorityQueue<>();

        while(!queue.isEmpty()) {
            ans.offer(queue.poll().num);
        }

        while(!ans.isEmpty()) {
            sb.append(ans.poll()).append(" ");
        }

        System.out.println(sb);
    }
}