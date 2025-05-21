const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (n) => {
}

const main = () => {
  const n = +readLine();

  const res = Array.from({ length : n }).map((_, idx) => {
    let temp = '';
    for (let i = 0 ; i < idx ; i++) {
      temp += ' ';
    }

    for (let i = 0 ; i < (n - idx) * 2 - 1 ; i++) {
      temp += '*';
    }

    return temp;
  })

  console.log(res.join('\n'));
}

main();