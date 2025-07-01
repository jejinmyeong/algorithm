const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const [ N, M ] = readLine().split(' ').map(Number);
  
  const map = Array(N).fill(null);
  const visited = Array.from({ length: N }, () => Array(M).fill(false));
  
  for (let i = 0 ; i < N ; i++) {
    map[i] = readLine().split('');
  }
  
  const D = [[ -1, 0 ], [ 0, 1 ], [ 1, 0 ], [ 0, -1 ]]; 
  
  const dfs = (x, y, pd) => {
    for (let d = 0 ; d < 4 ; d++) {
      if ((d + 2) % 4 === pd) continue;

      const nx = x + D[d][0];
      const ny = y + D[d][1];
      
      if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] !== map[x][y]) continue;
      
      if (visited[nx][ny]) {
        return true;
      } else {
        visited[nx][ny] = true;
        if (dfs(nx, ny, d)) return true;
      }
    }

    return false;
  }

  for (let i = 0 ; i < N ; i++) {
    for (let j = 0 ; j < M ; j++) {
      if (visited[i][j]) continue;
      visited[i][j] = true;

      if (dfs(i, j, -1)) {
        console.log("Yes");
        return;
      }
    }
  }
  
  console.log("No")
}

main();