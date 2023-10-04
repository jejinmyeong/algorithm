import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0 ; i < L ; i++) {
            String input = br.readLine();
            if (set.contains(input)) set.remove(input);
            set.add(input);
        }

        int cnt = 0;
        for (String s : set) {
            sb.append(s).append("\n");
            cnt++;
            if (cnt == K) {
                break;
            }
        }

        System.out.print(sb);
        
    }
}
