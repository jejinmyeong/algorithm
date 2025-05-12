const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}


const solution = () => {
}

const main = () => {
  const n = +readLine();

  const dp = new Array(5001).fill(0n);

  dp[0] = 1n;
  dp[2] = 1n;

  for (let i = 2 ; i < 2501 ; i++) {
    for (let j = 0 ; j < i ; j++) {
      dp[i * 2] += dp[j * 2] * dp[(i - 1 - j) * 2];
      dp[i * 2] %= 1000000007n;
    }
  }

  let ans = '';

  for (let i = 0 ; i < n ; i++) {
    ans += `${dp[+readLine()]}\n`;
  }

  console.log(ans)
}

main();
