const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = +input[0];
const numbers = input[1].split(" ").map(Number);
const ops = input[2].split(" ").map(Number); // + - * /

let max = -Infinity;
let min = Infinity;

function dfs(idx, current, plus, minus, mul, div) {
  if (idx === N) {
    max = Math.max(max, current);
    min = Math.min(min, current);
    return;
  }

  const num = numbers[idx];

  if (plus > 0) dfs(idx + 1, current + num, plus - 1, minus, mul, div);
  if (minus > 0) dfs(idx + 1, current - num, plus, minus - 1, mul, div);
  if (mul > 0) dfs(idx + 1, current * num, plus, minus, mul - 1, div);
  if (div > 0) {
    const next =
      current < 0
        ? -Math.floor(Math.abs(current) / num)
        : Math.floor(current / num);
    dfs(idx + 1, next, plus, minus, mul, div - 1);
  }
}

dfs(1, numbers[0], ops[0], ops[1], ops[2], ops[3]);

console.log(`${max}\n${min}`)
