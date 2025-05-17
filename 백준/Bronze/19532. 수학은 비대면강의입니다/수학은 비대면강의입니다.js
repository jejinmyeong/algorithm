const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  let [ a, b, c, d, e, f ] = readLine().split(' ').map(Number);

  for (let i = -999 ; i <= 999 ; i++) {
    for (let j = -999 ; j <= 999 ; j++) {
      if ((a * i + b * j) === c && (d * i + e * j) === f) {
        console.log(i, j);
        return;
      }
    }
  }
}

main();
