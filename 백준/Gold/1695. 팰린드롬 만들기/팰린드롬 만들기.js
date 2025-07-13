const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine();

  const arr = readLine().split(' ').map(Number);
  const dp = Array.from({ length: N + 1 }, () => Array(N + 1).fill(-1));

  const solution = (s, e) => {
    if (s >= e) return 0;

    if (dp[s][e] !== -1) return dp[s][e];

    let min = 0;

    if (arr[s] === arr[e]) min = solution(s + 1, e - 1);
    else min = Math.min(solution(s + 1, e) + 1, solution(s, e - 1) + 1);

    return dp[s][e] = min;
  }

  const res = solution(0, N - 1);

  console.log(res);
}


main();