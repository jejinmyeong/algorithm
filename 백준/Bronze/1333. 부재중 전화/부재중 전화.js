const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ N, L, D ] = readLine().split(' ').map(Number);

  const ring = Array((L + 5) * N + 1).fill(false);

  let now = 0;

  while (now <= (L + 5) * N) {
    for (let i = 0 ; i < L ; i++) {
      ring[now++] = true;
    }

    for (let i = 0 ; i < 5 ; i++) {
      now++;
    }
  }

  for (let i = 0 ; ; i++) {
    if (i * D >= (L + 5) * N || !ring[i * D]) {
      console.log(i * D);
      return;
    } 
  }
}

main();
