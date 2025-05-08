const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}


const solution = (N, pos) => {
  const [ r1, c1, r2, c2 ] = pos;
  let min = Infinity;
  const D = [[ -2, -1 ], [ -2, 1 ], [ 0, -2 ], [ 0, 2 ], [ 2, -1 ], [ 2, 1 ]];

  const visited = Array.from({ length: N }, () => Array(N));
  let queue = [[r1, c1, 0]];
  visited[r1][c1] = true;

  while (queue.length !== 0) {
    const [ r, c, cnt ] = queue.shift();

    if (r === r2 && c === c2) {
      min = cnt;
      break;
    }

    for (let d = 0 ; d < 6 ; d++) {
      let nr = r + D[d][0];
      let nc = c + D[d][1];

      if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;

      visited[nr][nc] = true;
      queue.push([nr, nc, cnt + 1]);
    }
  }

  console.log(min === Infinity ? -1 : min);
}

const main = () => {
  const N = +readLine();
  const pos = readLine().split(' ').map(Number);

  solution(N, pos);
}

main();
