import java.util.*;

class Solution {
    static class Mine implements Comparable<Mine> {
        int [] t = new int [3];
        
        Mine (int t1, int t2, int t3) {
            t[0] = t1;
            t[1] = t2;
            t[2] = t3;
        }
        
        @Override
        public int compareTo(Mine o) {
            return o.t[2] - this.t[2];
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int cnt = 0;
        for (int i = 0 ; i < picks.length ; i++) {
            cnt += picks[i];
        }
        
        int len = (int) Math.ceil((double) minerals.length / 5);
        
        PriorityQueue<Mine> queue = new PriorityQueue<>();
        
        for (int i = 0 ; i < Math.min(cnt, len) ; i++) {
            int t1 = 0;
            int t2 = 0;
            int t3 = 0;
            
            for (int j = i * 5 ; j < i * 5 + 5 ; j++) {
                if (j >= minerals.length) break;
                if ("diamond".equals(minerals[j])) {
                    t2 += 5;
                    t3 += 25;
                } else if ("iron".equals(minerals[j])) {
                    t2 += 1;
                    t3 += 5;
                } else {
                    t2 += 1;
                    t3 += 1;
                }
                t1 += 1;
            }
            
            queue.offer(new Mine(t1, t2, t3));
        }
        
        while (!queue.isEmpty()) {
            Mine now = queue.poll();
            
            if (picks[0] > 0) {
                answer += now.t[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += now.t[1];
                picks[1]--;
            } else {
                answer += now.t[2];
                picks[2]--;
            }
        }
        
        return answer;
    }
}