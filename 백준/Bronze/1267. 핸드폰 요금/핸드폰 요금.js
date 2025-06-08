const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine();
  const times = readLine().split(' ').map(Number);

  let Y = 0;
  let M = 0;

  for (let i = 0 ; i < N ; i++) {
    Y += Math.ceil((times[i] + 1) / 30) * 10;
    M += Math.ceil((times[i] + 1) / 60) * 15;
  }

  let ans = ''

  if (Y <= M) ans += 'Y ';
  if (M <= Y) ans += 'M ';

  ans += Math.min(Y, M);

  console.log(ans);
}

main();