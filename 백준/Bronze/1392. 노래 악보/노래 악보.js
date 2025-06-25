const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ N, Q ] = readLine().split(' ').map(Number);

  const arr = Array(N).fill(0);

  for (let i = 0 ; i < N ; i++) {
    arr[i] = +readLine();
  }

  const sum = Array(N + 1).fill(0);

  for (let i = 1 ; i <= N ; i++) {
    sum[i] = sum[i - 1] + arr[i - 1]
  }
  
  console.log(Array.from({ length: Q }).map(() => {
    const t = +readLine();
    for (let i = 1 ; i <= N ; i++) {
      if (t < sum[i]) {
        return i;
      }
    }
  }).join('\n'))
}

main();