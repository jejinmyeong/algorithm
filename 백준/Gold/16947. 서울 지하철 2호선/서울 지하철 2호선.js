const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

class Node {
  constructor(idx) {
    this.idx = idx;
    this.children = [];
  }

  add(idx) {
    this.children.push(idx);
  }
}

const main = () => {
  const N = +readLine();

  const nodes = Array(N + 1).fill(null).map((_, idx) => new Node(idx));

  for (let i = 0 ; i < N ; i++) {
    const [ s, e ] = readLine().split(' ').map(Number);

    nodes[s].add(e);
    nodes[e].add(s);
  }

  const visited = Array(N + 1).fill(false);
  const inCycle = Array(N + 1).fill(false);

  
  const dfs = (cur, prev) => {
    if (visited[cur]) {
      inCycle[cur] = true;
      return true
    };

    visited[cur] = true;
    
    for (const c of nodes[cur].children) {
      if (c === prev) continue;
      
      if (dfs(c, cur)) {
        if (!inCycle[cur]) {
          inCycle[cur] = true;
          return true;
        } else {
          return false;
        }
      }
    }

    return false;
  }

  dfs(1, -1);
  
  const distance = Array(N + 1).fill(-1);

  for (let i = 1 ; i <= N ; i++) {
    if (!inCycle[i]) continue;
    const queue = [[i, 0]];

    
    while (queue.length !== 0) {
      const [ cur, dist ] = queue.shift();

      distance[cur] = dist;

      for (const c of nodes[cur].children) {
        if (inCycle[c] || distance[c] !== -1) continue;

        queue.push([c, dist + 1]);
      }
    }
  }

  console.log(distance.filter((_, idx) => idx !== 0).join(' '));
}

main();