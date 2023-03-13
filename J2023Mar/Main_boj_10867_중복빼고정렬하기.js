let fs = require("fs");
let input = fs.readFileSync("dev/stdin").toString().trim().split("\n");

let N = input[0];
let set = new Set(input[1].split(" ").map(Number));

let arr = [...set];

arr.sort((a, b) => {
  return a - b;
});

console.log(arr.join(" "));
