let fs = require("fs");
let input = fs.readFileSync("dev/stdin").toString().trim().split("\n");

let N = input[0];

let A = input[1].split(" ").map(Number);
let B = input[2].split(" ").map(Number);

A.sort((a, b) => {
  return a - b;
});
B.sort((a, b) => {
  return b - a;
});

let ans = 0;
for (let i = 0; i < N; i++) {
  ans += A[i] * B[i];
}

console.log(ans);
