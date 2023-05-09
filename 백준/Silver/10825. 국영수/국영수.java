import java.io.*;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        String name;
        int k, e, m;

        Student(String name, int k, int e, int m) {
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }

        @Override
        public int compareTo(Student o) {
            if (this.k == o.k && this.e == o.e && this.m == o.m) return this.name.compareTo(o.name);
            else if (this.k == o.k && this.e == o.e) return o.m - this.m;
            else if (this.k == o.k) return this.e - o.e;
            return o.k - this.k;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Student [] students = new Student[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            students[i] = new Student(name, k, e, m);
        }

        Arrays.sort(students);

        for (Student s : students) {
            sb.append(s.name).append("\n");
        }

        System.out.print(sb);

    }
}
