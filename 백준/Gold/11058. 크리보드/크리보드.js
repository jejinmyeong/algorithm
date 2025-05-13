const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}


const solution = () => {
}

const main = () => {
  const N = +readLine();

  const dp = Array(101).fill(0);

  dp[1] = 1;
  dp[2] = 2;
  dp[3] = 3;

  for (let i = 4 ; i <= N ; i++) {
    dp[i] = Math.max(dp[i], dp[i - 1] + 1);
    for (let j = 0 ; j <= N - i ; j++) {
      dp[i + j] = Math.max(dp[i + j], dp[i - 3] * (j + 2))
    }
  }

  console.log(dp[N])

}

main();
