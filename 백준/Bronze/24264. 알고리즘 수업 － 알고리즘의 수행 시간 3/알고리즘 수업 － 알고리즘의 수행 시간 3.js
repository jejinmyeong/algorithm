const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (idx, L, P, V) => {
}

const main = () => {
  console.log(`${Math.pow(+readLine(), 2)}\n2`)
}

main();