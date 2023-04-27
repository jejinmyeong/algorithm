import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int len = number.length() - k;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0 ; i < number.length() ; i++) {
            queue.offer(number.charAt(i) - '0');
        }
        
        Stack<Integer> stack = new Stack<>();
        
        while(!queue.isEmpty()) {
            if (stack.isEmpty()) {
                stack.push(queue.poll());
                continue;
            }
            
            while (stack.peek() < queue.peek()) {
                if (k == 0) break;
                
                stack.pop();
                k--;
                
                if (stack.isEmpty()) break;
            }

            stack.push(queue.poll());
        }
        
        while (stack.size() != len) {
            stack.pop();
        }
        
        while (!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        
        return answer;
    }
}