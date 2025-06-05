const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

const main = () => {
  const str = readLine();

  let ans = '';

  for (const c of str) {
    if (/[a-z]/.test(c)) {
      let ascii = c.charCodeAt(0);
      
      if (ascii <= 'z'.charCodeAt(0) - 13) ascii += 13;
      else ascii = 'a'.charCodeAt(0) + 13 - 'z'.charCodeAt(0) + ascii - 1;

      ans += String.fromCharCode(ascii);
    } else if (/[A-Z]/.test(c)) {
      let ascii = c.charCodeAt(0);

      if (ascii <= 'Z'.charCodeAt(0) - 13) ascii += 13;
      else ascii = 'A'.charCodeAt(0) + 13 - 'Z'.charCodeAt(0) + ascii - 1;

      ans += String.fromCharCode(ascii);
    } else {
      ans += c;
    }
  }

  console.log(ans);
}

main();