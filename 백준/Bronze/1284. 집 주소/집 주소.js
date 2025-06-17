const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  let ans = '';

  while (true) {
    const N = readLine();

    if (N === '0') break;
    
    let len = 1;
    for (let i = 0 ; i < N.length ; i++) {
      if (N[i] === '1') {
        len += 3;
      } else if (N[i] === '0') {
        len += 5;
      } else {
        len += 4;
      }
    }

    ans += len + '\n';
  }
  console.log(ans)
}

main();