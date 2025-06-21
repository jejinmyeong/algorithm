const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = readLine();
  
  for (let i = 1 ; i < N.length ; i++) {
    const front = N.slice(0, i).split('').map(Number).reduce((p, v) => p * v, 1);
    const back = N.slice(i).split('').map(Number).reduce((p, v) => p * v, 1);

    if (front === back) {
      console.log("YES");
      return;
    }
  }

  console.log("NO");
}

main();
