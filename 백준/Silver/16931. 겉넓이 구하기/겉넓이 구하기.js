const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main() {
  const [N, M] = input[0].split(" ").map(Number);

  const blocks = Array.from({ length: N }, () => Array(M).fill(0));

  for (let i = 1 ; i <= N ; i++) {
    const arr = input[i].split(" ").map(Number);

    for (let j = 0 ; j < M ; j++) {
      blocks[i - 1][j] = arr[j];
    }
  }

  let ans = N * M * 2;

  // 정면, 후면
  for (let i = 0 ; i < N ; i++) {
    ans += blocks[i][0];
    for (let j = 0 ; j < M - 1 ; j++) {
      ans += Math.abs(blocks[i][j + 1] - blocks[i][j]);
    }
    ans += blocks[i][M - 1];
  }

  // 왼측면, 우측면
  for (let i = 0 ; i < M ; i++) {
    ans += blocks[0][i];
    for (let j = 0 ; j < N - 1 ; j++) {
      ans += Math.abs(blocks[j + 1][i] - blocks[j][i]);
    }
    ans += blocks[N - 1][i];
  }
  console.log(ans);
}

main();
