const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (n) => {
}

const main = () => {
  const n = +readLine();

  const dp = Array(n + 1);

  dp[0] = 2;

  for (let i = 1 ; i <= n ; i++) {
    dp[i] = dp[i - 1] + dp [i - 1] - 1;
  }

  console.log(dp[n] * dp[n])
}

main();
