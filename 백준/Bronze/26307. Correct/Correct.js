const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ h, m ] = readLine().split(" ").map(Number);

  const base = 9 * 60;
  const result = h * 60 + m;

  console.log(result - base)
}

main();