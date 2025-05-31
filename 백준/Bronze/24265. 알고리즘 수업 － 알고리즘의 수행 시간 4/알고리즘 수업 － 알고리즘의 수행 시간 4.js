const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (idx, L, P, V) => {
}

const main = () => {
  const N = +readLine();

  console.log(`${N * (N - 1) / 2}\n2`)
}

main();