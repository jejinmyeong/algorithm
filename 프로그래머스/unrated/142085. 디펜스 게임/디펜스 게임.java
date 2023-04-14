import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
        
        for (int i = 0 ; i < enemy.length ; i++) {
            // 무적권이 없고 적의 수가 내 병력수보다 많을 때
            if (enemy[i] > n && k == 0) {
                break;
            }
            
            // 이전에 진행했던 라운드 중 병력이 제일 많은 경우보다 이번 라운드의 적 병력이 많을 경우
            if (n < enemy[i] && (queue.isEmpty() || queue.peek() < enemy[i])) {
                k--;
                answer++;
                continue;
            }
            
            while (n < enemy[i] && !queue.isEmpty() && k > 0) {
                n += queue.poll();
                k--;
            }
            
            n -= enemy[i];
            queue.offer(enemy[i]);
            answer++;
            
        }
        return answer;
    }
}