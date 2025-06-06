const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine();

  let last = 0n;
  let ans = BigInt(0);

  for (let i = 1 ; i < N - 1 ; i++) {
    last = last + BigInt(i);
    ans += last;
  }

  console.log(`${ans}\n3`)
}

main();