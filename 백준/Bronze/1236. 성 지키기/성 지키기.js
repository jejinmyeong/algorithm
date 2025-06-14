const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ N, M ] = readLine().split(' ').map(Number);

  const map = Array.from({ length: N }, () => Array(M));
  
  for (let i = 0 ; i < N ; i++) {
    map[i] = readLine().split('');
  }
  
  let x = 0;
  let y = 0;

  for (let i = 0 ; i < N ; i++) {
    let temp = 0;
    for (let j = 0 ; j < M ; j++) {
      if (map[i][j] === 'X') temp++
    }
    if (temp === 0) x++;
  }

  for (let i = 0 ; i < M ; i++) {
    let temp = 0;
    for (let j = 0 ; j < N ; j++) {
      if (map[j][i] === 'X') temp++
    }
    if (temp === 0) y++;
  }

  console.log(Math.max(x, y))
}

main();