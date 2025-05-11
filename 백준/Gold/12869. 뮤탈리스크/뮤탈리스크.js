const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const n = +readLine();
  const hps = Array(3).fill(0);
  
  readLine().split(' ').map(Number).forEach((v, idx) => hps[idx] = v);

  const D = [[9, 3, 1], [9, 1, 3], [3, 9, 1], [3, 1, 9], [1, 9, 3], [1, 3, 9]];

  const visited = Array.from({ length: 61 }, () => Array.from({ length: 61 }, () => Array(61).fill(false)));
  
  const queue = [[0, ...hps]];
  visited[hps[0]][hps[1]][hps[2]] = true;

  while (queue.length !== 0) {
    const [ cnt, ...now ] = queue.shift();

    if (now.every((v) => v <= 0)) {
      console.log(cnt);
      break;
    }

    for (let d = 0 ; d < 6 ; d++) {
      const hp1 = Math.max(0, now[0] - D[d][0]);
      const hp2 = Math.max(0, now[1] - D[d][1]);
      const hp3 = Math.max(0, now[2] - D[d][2]);

      if (visited[hp1][hp2][hp3]) continue;

      visited[hp1][hp2][hp3] = true;
      queue.push([ cnt + 1, hp1, hp2, hp3 ]);
    }
  }
}

main();
