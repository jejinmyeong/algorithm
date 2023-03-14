let fs = require("fs");
let input = fs.readFileSync("dev/stdin").toString().trim().split("\n");

for (let i = 0; i < input.length; i++) {
  let tc = input[i].split(" ").map(Number);

  if (tc[0] === 0) break;
  bfs(tc, 1, 0, "");
  console.log();
}

function bfs(arr, idx, cnt, res) {
  if (cnt === 6) {
    console.log(res);
    return;
  }

  for (let i = idx; i < arr.length; i++) {
    bfs(arr, i + 1, cnt + 1, res + arr[i] + " ");
  }
}
