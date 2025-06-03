const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  let max = 0;
  let now = 0;

  for (let i = 0 ; i < 4 ; i++) {
    const [ a, b ] = readLine().split(' ').map(Number);

    now += b - a;

    max = Math.max(max, now);
  }

  console.log(max);
}

main();