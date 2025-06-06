const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine() - 2;

  console.log(`${(BigInt(N) ** 3n + 3n * BigInt(N) ** 2n + 2n * BigInt(N)) / 6n}\n3`);
}

main();