const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const D = [[ -1, 0 ], [ 0, 1 ], [ 1, 0 ], [ 0, -1]];
let N, M;
let map;
let visited;
let curX, curY;

const dfs = (x, y, cnt) => {
  for (let d = 0 ; d < 4 ; d++) {
    const nx = x + D[d][0];
    const ny = y + D[d][1];

    if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] !== map[x][y]) continue;

    if (visited[nx][ny]) {
      if (cnt >= 4 && curX === nx && curY === ny) {
        console.log('Yes');
        process.exit(0);
      }
    } else {
      visited[nx][ny] = true;
      dfs(nx, ny, cnt + 1);
    }
  }
}

const main = () => {
  [ N, M ] = readLine().split(' ').map(Number);

  map = Array(N).fill(null);

  for (let i = 0 ; i < N ; i++) {
    map[i] = readLine().split('');
  }

  for (let i = 0 ; i < N ; i++) {
    for (let j = 0 ; j < M ; j++) {
      visited = Array.from({ length: N }, () => Array(M).fill(false));
      visited[i][j] = true;
      curX = i;
      curY = j;

      dfs(i, j, 1);
    }
  }
  
  console.log("No")
}

main();