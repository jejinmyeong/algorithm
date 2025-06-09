const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ N, M, K ] = readLine().split(' ').map(Number);

  let team = Math.min(parseInt(N / 2), M);

  let std = N + M - team * 3;

  if (std < K) team -= Math.ceil((K - std) / 3);

  console.log(team);
}

main();