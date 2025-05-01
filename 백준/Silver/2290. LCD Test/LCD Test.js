const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main() {
  const [s, n] = input[0].split(" ").map(Number);

  let ans = '';

  for (let i = 0 ; i < 2 * s + 3 ; i++) {
    const nums = n.toString().split('').map(Number);

    for (let j of nums) {
      if (i === 0) {
        if (j === 1 || j === 4) {
          ans = ans.concat(" ");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat(" ");
          }
          ans = ans.concat(" ");
        } else {
          ans = ans.concat(" ");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat("-");
          }
          ans = ans.concat(" ");
        }
      } else if (i === s + 1) {
        if (j === 1 || j === 7 || j === 0) {
          ans = ans.concat(" ");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat(" ");
          }
          ans = ans.concat(" ");
        } else {
          ans = ans.concat(" ");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat("-");
          }
          ans = ans.concat(" ");
        }
      } else if (i === 2 * s + 2) {
        if (j === 1 || j === 4 || j === 7) {
          ans = ans.concat(" ");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat(" ");
          }
          ans = ans.concat(" ");
        } else {
          ans = ans.concat(" ");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat("-");
          }
          ans = ans.concat(" ");
        }
      } else if (i < s + 1) {
        if (j === 1 || j === 2 || j === 3 || j === 7) {
          ans = ans.concat(" ");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat(" ");
          }
          ans = ans.concat("|");
        } else if (j === 4 || j === 8 || j === 9 || j === 0) {
          ans = ans.concat("|");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat(" ");
          }
          ans = ans.concat("|");
        } else {
          ans = ans.concat("|");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat(" ");
          }
          ans = ans.concat(" ");
        }
      } else {
        if (j === 1 || j === 3 || j === 4 || j === 5 || j === 7 || j === 9) {
          ans = ans.concat(" ");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat(" ");
          }
          ans = ans.concat("|");
        } else if (j === 6 || j === 8 || j === 0) {
          ans = ans.concat("|");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat(" ");
          }
          ans = ans.concat("|");
        } else {
          ans = ans.concat("|");
          for (let k = 0 ; k < s ; k++) {
            ans = ans.concat(" ");
          }
          ans = ans.concat(" ");
        }
      }
      
      ans = ans.concat(" ");
    }
    ans = ans.concat('\n');
  }

  console.log(ans);
}

main();
