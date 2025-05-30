const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (idx, L, P, V) => {
}

const main = () => {
  const N = +readLine();

  const arr = Array(N).fill(0);

  for (let i = 0 ; i < N ; i++) {
    arr[i] = +readLine();
  }

  let max = 0;
  let ans = 0;

  for (let i = N - 1 ; i >= 0 ; i--) {
    if (arr[i] > max) {
      max = arr[i];
      ans++;
    }
  }

  console.log(ans);
}

main();