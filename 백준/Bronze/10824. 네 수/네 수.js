const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = () => {
}

const main = () => {
  const [ A, B, C, D ] = readLine().split(' ');

  console.log(parseInt(A + B) + parseInt(C + D));
}

main();