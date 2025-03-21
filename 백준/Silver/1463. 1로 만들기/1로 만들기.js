const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

function main () {
    let X = parseInt(input[0]);

    const dp = Array(X + 1).fill(Infinity);

    dp[1] = 0;

    for (let i = 1 ; i <= X ; i++) {
        if (i * 2 <= X) dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
        if (i * 3 <= X) dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        if (i + 1 <= X) dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
    }

    console.log(dp[X]);
}

main();