import java.util.*;

class Solution {
    static class Truck {
        int w, l;
        Truck(int w, int l) {
            this.w = w;
            this.l = l;
        }
        
        public void drive() {
            this.l++;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Truck> onBridge = new LinkedList<>();
        Queue<Truck> wait = new LinkedList<>();
        
        for (int i = 0 ; i < truck_weights.length ; i++) {
            wait.offer(new Truck(truck_weights[i], 1));
        }
        
        int sum = 0;
        
        while (!onBridge.isEmpty() || !wait.isEmpty()) {
            answer++;
            if (onBridge.isEmpty()) {
                Truck next = wait.poll();
                onBridge.offer(next);
                sum += next.w;
                continue;
            }
            
            for (Truck t : onBridge) {
                t.drive();
            }
            
            if (onBridge.peek().l > bridge_length) {
                Truck now = onBridge.poll();
                sum -= now.w;
            }
            
            
            if (!wait.isEmpty() && sum + wait.peek().w <= weight) {
                Truck next = wait.poll();
                onBridge.offer(next);
                sum += next.w;
            }
        }
        
        return answer;
    }
}