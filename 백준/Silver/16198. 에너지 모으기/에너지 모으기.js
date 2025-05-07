const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

let max = -Infinity;

const solution = (N, weights) => {
  backTracking(weights, 0);

  console.log(max);
}

const backTracking= (weights, cur) => {
  if (weights.length === 2) {
    max = Math.max(max, cur);

    return;
  }

  for (let i = 1 ; i < weights.length - 1 ; i++) {
    const next = cur + weights[i - 1] * weights[i + 1];
    const temp = weights.filter((_, idx) => idx !== i);

    backTracking(temp, next);
  }
}

const main = () => {
  const N = +readLine();
  const weights = readLine().split(' ').map(Number);

  solution(N, weights);
}

main();
