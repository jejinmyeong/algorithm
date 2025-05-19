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

  console.log([ Math.PI * n * n, n * n * 2 ].join('\n'));
  
}

main();