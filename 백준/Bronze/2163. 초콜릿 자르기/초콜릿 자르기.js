const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (n) => {
}

const main = () => {
  const [ n, m ] = readLine().split(' ').map(Number);

  console.log(n * m - 1);
}

main();