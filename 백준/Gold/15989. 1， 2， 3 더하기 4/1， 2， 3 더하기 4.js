const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const t = +readLine();

  const dp = Array.from({ length: 10001 }, () => Array(4).fill(0));

  dp[1][1] = 1;
  dp[2][1] = 1;
  dp[2][2] = 1;
  dp[3][1] = 1;
  dp[3][2] = 1;
  dp[3][3] = 1;

  for (let i = 4 ; i <= 10000 ; i++) {
    dp[i][1] = dp[i - 1][1];
    dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
    dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
  }

  let ans = '';

  for (let i = 0 ; i < t ; i++) {
    const n = +readLine();
    ans += `${dp[n][1] + dp[n][2] + dp[n][3]}\n`;  
  }

  console.log(ans);
}

main();
