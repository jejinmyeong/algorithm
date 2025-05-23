const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (n) => {
}

const main = () => {
  const M = +readLine();
  const N = +readLine();


  let ans = 0;
  let min = Number.MAX_VALUE;

  if (Math.sqrt(M) === parseInt(Math.sqrt(M))) {
    ans += M
    min = M;
  };

  for (let i = parseInt(Math.sqrt(M)) + 1 ; i <= Math.sqrt(N) ; i++) {
    ans += i * i;
    min = Math.min(min, i * i);
  }

  if (ans === 0) console.log(-1);
  else console.log(`${ans}\n${min}`)
}

main();