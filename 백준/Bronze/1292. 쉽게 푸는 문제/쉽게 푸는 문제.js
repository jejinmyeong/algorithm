const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (n) => {
}

const main = () => {
  const [ A, B ] = readLine().split(' ').map(Number);

  const sum = Array(B + 1).fill(0);

  let cnt = 0;
  let num = 1;

  for (let i = 1 ; i <= B ; i++) {
    if (cnt < num) cnt++;
    else {
      num++
      cnt = 1;
    }

    sum[i] = sum[i - 1] + num;
  }

  console.log(sum[B] - sum[A - 1]);
}

main();