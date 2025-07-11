const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine();
  const nodes = Array.from({ length: N + 1 }, () => []);

  for (let i = 0 ; i < N - 1 ; i++) {
    const [ s, e ] = readLine().split(' ').map(Number);

    nodes[s].push(e);
    nodes[e].push(s);
  }

  const arr = readLine().split(' ').map(Number);

  const visited = Array(N + 1).fill(false);

  const start = arr.shift();

  if (start !== 1) {
    console.log(0);
    return;
  }

  const queue = [start];
  visited[start] = true;

  const temp = new Set();

  while (queue.length !== 0) {
    const cur = queue.shift();

    for (const n of nodes[cur]) {
      if (visited[n]) continue;

      visited[n] = true;
      temp.add(n);
    }

    for (let i = 0 ; i < temp.size ; i++) {
      let num = arr.shift();
      if (temp.has(num)) queue.push(num);
      else {
        console.log(0);
        return;
      }
    }
    temp.clear();
  }

  if (arr.length === 0) {
    console.log(1);
  } else {
    console.log(0);
  }
}


main();