const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
};

const main = () => {
  const weight = +readLine();
  const height = +readLine();

  const bmi = weight / (height * height);

  if (bmi < 18.5) {
    console.log("Underweight");
  } else if (bmi < 25) {
    console.log("Normal weight");
  } else if (bmi < 30) {
    console.log("Overweight");
  }
};

main();
