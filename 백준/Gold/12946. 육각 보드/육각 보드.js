const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const N = +readLine();
  
  const map = Array(N).fill(null).map(() => Array(N).fill(false));

  for (let i = 0 ; i < N ; i++) {
    const line = readLine().split('');

    for (let j = 0 ; j < N ; j++) {
      if (line[j] === 'X') map[i][j] = true;
    }
  }

  const D = [[-1, 0], [-1, 1], [0, 1], [1, 0], [1, -1], [0, -1]];

  const visited = Array(N).fill(null).map(() => Array(N).fill(false));
  const colors = Array(N).fill(null).map(() => Array(N).fill(0));

  let ans = 0;

  for (let i = 0 ; i < N ; i++) {
    for (let j = 0 ; j < N ; j++) {
      if (!map[i][j] || visited[i][j]) continue;

      const queue = [[i, j]];
      visited[i][j] = true;

      while (queue.length !== 0) {
        const [x, y] = queue.shift();

        let temp = 0;

        for (let d = 0 ; d < 6 ; d++) {
          const nx = x + D[d][0];
          const ny = y + D[d][1];

          if (nx < 0 || ny < 0 || nx >= N || ny >= N || !map[nx][ny]) continue;

          if (colors[nx][ny] !== 0) {
            temp = temp | colors[nx][ny];
          } 
          
          if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            queue.push([nx, ny]);
          }
        }

        if (temp === 3) {
          console.log(3);
          return;
        } else if (temp === 0) {
          colors[x][y] = 1;
        } else {
          colors[x][y] = temp ^ 3;
        }

        ans = Math.max(colors[x][y], ans);
      }
    }
  }

  console.log(ans);
}


main();