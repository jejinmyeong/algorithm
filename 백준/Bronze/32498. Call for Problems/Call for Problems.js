const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
};

const main = () => {
  const n = +readLine();
  let ans = 0;

  for (let i = 0 ; i < n ; i++) {
    const p = +readLine();
    if (p % 2 !== 0) ans++;
  }

  console.log(ans)
};

main();
