const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function solution(A, B, C) {
    console.log(Math.max(C - B, B - A) - 1);
}

rl.on('line', (userInput) => {
    solution(...userInput.split(' ').map(Number));
}).on('close', () => {
    process.exit();
});