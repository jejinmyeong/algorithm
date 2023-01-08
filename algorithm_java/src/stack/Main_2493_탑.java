package stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Stack에서 기존 tower의 index를 찾을 수 없어서 만든 Tower 자료구조
class Tower {
	int num; // 입력 받은 towers의 indexNum
	int h;   // tower 높이
	
	public Tower(int n, int h) {
		this.num = n;
		this.h = h;
	}
}

public class Main_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Stack<Tower> towers = new Stack<>();
		int[] ans = new int[N];
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
						
			while (!towers.isEmpty()) {
				// stack의 가장 위쪽 tower의 높이와 입력받은 tower 높이 비교
				if(towers.peek().h >now) {
					ans[i] = towers.peek().num+1;
					towers.push(new Tower(i,now));
					break;
				}else {
					towers.pop();
				}
			}
			
			// stack이 비어있으면 하나 채움
			if (towers.isEmpty()) {
				towers.push(new Tower(i, now));
				continue;
			}
		}
		for(int a:ans) System.out.print(a+" ");


	}
}
