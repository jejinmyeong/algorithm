const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
};

const main = () => {
  const N = +readLine();

  console.log(
    Array(N)
      .fill(null)
      .map(() => {
        const str = readLine();

        let cur = "";
        let temp = "";

        for (const s of str) {
          if (cur === s) continue;
          cur = s;
          temp += s;
        }

        return temp;
      })
      .join("\n")
  );
};

main();
