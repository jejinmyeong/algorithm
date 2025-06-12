const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ A, B ] = readLine().split(' ');

  let ans = 0;

  for (const a of A) {
    for (const b of B) {
      ans += +a * +b;
    }
  }

  console.log(ans);
}

main();