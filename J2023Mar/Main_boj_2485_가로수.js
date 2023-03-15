let fs = require('fs');
let input = fs.readFileSync('dev/stdin').toString().trim().split('\n');

let N = parseInt(input[0].trim());

let trees = [];

for (let i = 1 ; i < input.length ; i++) {
  trees.push(parseInt(input[i].trim()));
}

let sub = [];

for (let i = 1 ; i < N ; i++) {
  sub.push(trees[i] - trees[i - 1]);
}

for (let i = 0 ; i < sub.length - 1 ; i++) {
  sub[i + 1] = gcd(sub[i], sub[i + 1]);
}
console.log((trees[N - 1] - trees[0]) / sub[sub.length - 1] - (N - 1));

function gcd (a, b) {
  return b === 0 ? a : gcd(b, a % b);
}