var fs = require("fs");
var input = fs.readFileSync("dev/stdin").toString().trim().split("\n");

let N = input[0];
let set = new Set(input[1].split(" ").map(Number));

let M = input[2];
let cards = input[3].split(" ").map(Number);

let answer = [];

for (let i = 0; i < cards.length; i++) {
  if (set.has(cards[i])) answer.push(1);
  else answer.push(0);
}

console.log(answer.join(" "));
