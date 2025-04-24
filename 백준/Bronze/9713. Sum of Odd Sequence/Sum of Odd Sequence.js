const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const T = parseInt(input[0]);

    const max = Math.max(...input.slice(1).map(Number));

    const dp = Array(max + 1);

    dp[1] = 1;

    for (let i = 3 ; i <= max ; i++) {
        if (i % 2 === 0) continue;
        dp[i] = dp[i - 2] + i;
    }

    let ans = '';

    for (let i = 1 ; i <= T ; i++) {
        ans = ans.concat(dp[parseInt(input[i])] + '\n');
    } 

    console.log(ans);
}

main();