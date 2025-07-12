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

  let idx = 1;

  const dfs = (cur) => {
    if (visited[cur]) return;

    visited[cur] = true;

    const temp = new Set();

    for (const next of nodes[cur]) {
      if (visited[next]) continue;

      temp.add(next);
    }

    for (let i = 0 ; i < temp.size ; i++) {
      const next = arr[idx++];

      if (temp.has(next)) dfs(next);
      else {
        console.log(0);
        process.exit(0);
      }
    }
  }

  dfs(1);

  if (idx === N) {
    console.log(1);
  } else {
    console.log(0);
  }
}


main();