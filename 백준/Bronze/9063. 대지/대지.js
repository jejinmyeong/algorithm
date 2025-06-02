const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine();

  let minX = 10001;
  let maxX = -10001;
  let minY = 10001;
  let maxY = -10001;

  for (let i = 0 ; i < N ; i++) {
    const [ x, y ] = readLine().split(' ').map(Number);

    minX = Math.min(x, minX);
    maxX = Math.max(x, maxX);
    minY = Math.min(y, minY);
    maxY = Math.max(y, maxY);
  }

  console.log((maxX - minX) * (maxY - minY));
}

main();