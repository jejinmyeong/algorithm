const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const solution = (idx, L, P, V) => {
}

const main = () => {
  let N = +readLine();

  let ans = '';

  for (let i = 1 ; i < N ; i++) {
    for (let j = 0 ; j < i ; j++) {
      ans += '*'
    }
    ans += '\n';
  } 

  for (let i = N ; i > 0 ; i--) {
    for (let j = 0 ; j < i ; j++) {
      ans += '*';
    }
    ans += '\n';
  }

  console.log(ans);
}

main();