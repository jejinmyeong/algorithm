const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (n) => {
}

const main = () => {
  const [ n, k ] = readLine().split(' ').map(Number);
  const x = readLine().split(' ').map(Number).sort((a, b) => b - a);

  console.log(x[k - 1]);
}

main();