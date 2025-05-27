const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (idx, L, P, V) => {
  if (L === 0 && P === 0 && V === 0) return;

  return `Case ${idx}: ${parseInt(V / P) * L + (V % P >= L ? L : V % P)}`
}

const main = () => {
  const res = Array.from({ length: input.length }).map((_, idx) => solution(idx + 1, ...readLine().split(' ').map(Number)));

  console.log(res.join('\n'));
}

main();