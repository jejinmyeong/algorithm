const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ N, M ] = readLine().split(' ').map(Number);

  const boxes = readLine().split(' ').map(Number);
  const books = readLine().split(' ').map(Number);

  let ans = 0;
  let boxIdx = 0;
  for (let i = 0 ; i < M ;) {
    if (boxes[boxIdx] >= books[i]) {
      boxes[boxIdx] -= books[i];
      i++;
    } else {
      boxIdx++;
    }
  }

  console.log(boxes.reduce((p, v) => p + v, 0));
}

main();