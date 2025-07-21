const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
};

const main = () => {
  console.log(
    Array(input.length)
      .fill(null)
      .map(() => {
        const str = readLine();
        let temp = "";

        for (const s of str) {
          if (s === "i") temp += "e";
          else if (s === "e") temp += "i";
          else if (s === "I") temp += "E";
          else if (s === "E") temp += "I";
          else temp += s;
        }

        return temp;
      })
      .join("\n")
  );
};

main();
