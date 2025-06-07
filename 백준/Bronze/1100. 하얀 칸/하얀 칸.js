const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  let ans = 0;

  for (let i = 0 ; i < 8 ; i++) {
    const line = readLine().split('');
    for (let j = 0 ; j < 8 ; j++) {
      if ((i + j) % 2 === 0 && line[j] === 'F') ans++;
    }
  }

  console.log(ans)
}

main();