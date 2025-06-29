const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine();
  const visited = Array(N + 1).fill(false);

  const hopes = readLine().split(' ').map(Number);

  let ans = 0;
  for (let i = 0 ; i < N ; i++) {
    if (visited[hopes[i]]) ans++;

    visited[hopes[i]] = true;
  }

  console.log(ans);
}

main();