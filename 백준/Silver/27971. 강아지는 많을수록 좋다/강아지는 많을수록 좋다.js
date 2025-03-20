const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

class Node {
    constructor(num, cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

function main() {
    const [ N, M, A, B ] = input[0].split(' ').map(Number);

    const dp = [];

    dp[0] = 0;

    for (let i = 1 ; i <= N ; i++) {
        dp[i] = Number.MAX_VALUE;
    }

    const queue = [];
    
    for (let i = 1 ; i <= M ; i++) {
        const [ L, R ] = input[i].split(' ').map(Number);
        
        for (let j = L ; j <= R ; j++) {
            dp[j] = -1;
        }
    }

    if (dp[A] !== -1) {
        queue.push(new Node(A, 1));
        dp[A] = 1;
    }
    if (dp[B] !== -1) {
        queue.push(new Node(B, 1));
        dp[B] = 1;
    }
    
    while(queue.length !== 0) {
        let now = queue.shift();

        if (now.num + A <= N && dp[now.num + A] !== -1 && now.cnt + 1 < dp[now.num + A]) {
            dp[now.num + A] = Math.min(now.cnt + 1, dp[now.num + A])
            queue.push(new Node(now.num + A, now.cnt + 1))
        } 
        
        if (now.num + B <= N && dp[now.num + B] !== -1 && now.cnt + 1 < dp[now.num + B]) {
            dp[now.num + B] = Math.min(now.cnt + 1, dp[now.num + B])
            queue.push(new Node(now.num + B, now.cnt + 1))
        }
    }

    console.log(dp[N] === Number.MAX_VALUE ? -1 : dp[N])
}

main();