const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
};

const main = () => {
  const N = +readLine();

  const sumbit = [];
  const answer = [];

  for (let i = 0; i < N; i++) {
    sumbit.push(readLine());
  }
  for (let i = 0; i < N; i++) {
    answer.push(readLine());
  }

  let cnt = 0;

  for (let i = 0; i < N; i++) {
    if (sumbit[i] === answer[i]) cnt++;
  }

  console.log(cnt);
};

main();
