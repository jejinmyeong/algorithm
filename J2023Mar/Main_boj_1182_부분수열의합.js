let fs = require("fs");
let input = fs.readFileSync("dev/stdin").toString().trim().split("\n");

let NS = input[0].split(" ").map(Number);

let N = NS[0];
let S = NS[1];

let arr = input[1].split(" ").map(Number);

let ans = 0;
dfs(0, 0);

console.log(S === 0 ? ans - 1 : ans);

function dfs(cnt, sum) {
  if (cnt === N) {
    if (sum === S) ans++;

    return;
  }

  dfs(cnt + 1, sum + arr[cnt]);
  dfs(cnt + 1, sum);
}
