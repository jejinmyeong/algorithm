const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main() {
  const [ H, W, X, Y ] = input[0].split(' ').map(Number);

  const arr = Array.from({ length: H + X }, () => Array(W + Y));

  for (let i = 0 ; i < H + X ; i++) {
    const line = input[i + 1].split(' ').map(Number);

    for (let j = 0 ; j < W + Y ; j++) {
      arr[i][j] = line[j];
    }
  }

  for (let i = 0 ; i < H ; i++) {
    for (let j = 0 ; j < W ; j++) {
      arr[i + X][j + Y] -= arr[i][j];
    }
  }

  let ans = '';

  for (let i = 0 ; i < H ; i++) {
    ans = ans.concat(arr[i].filter((_, idx) => idx < W).join(' ') + '\n');
  }

  console.log(ans);
}

main();
