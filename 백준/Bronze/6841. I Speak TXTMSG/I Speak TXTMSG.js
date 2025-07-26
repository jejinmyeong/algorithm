const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
};

const main = () => {
  console.log(
    input
      .map((line) => {
        switch (line) {
          case "CU":
            return "see you";
          case ":-)":
            return "I’m happy";
          case ":-(":
            return "I’m unhappy";
          case ";-)":
            return "wink";
          case ":-P":
            return "stick out my tongue";
          case "(~.~)":
            return "sleepy";
          case "TA":
            return "totally awesome";
          case "CCC":
            return "Canadian Computing Competition";
          case "CUZ":
            return "because";
          case "TY":
            return "thank-you";
          case "YW":
            return "you’re welcome";
          case "TTYL":
            return "talk to you later";
          default:
            return line;
        }
      })
      .join("\n")
  );
};

main();
