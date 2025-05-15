const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let currentLine = 0;

const readLine = () => {
  return input[currentLine++];
}

class Node {
  constructor() {
    this.children = new Map();
    this.fail = null;
    this.isFinish = false;
  }
}

class Trie {
  constructor() {
    this.root = new Node();
  }

  insert(word) {
    let cur = this.root;

    for (const c of word) {
      if (!cur.children.has(c)) {
        cur.children.set(c, new Node());
      }
      cur = cur.children.get(c);
    }

    cur.isFinish = true;
  }

  failure() {
    const queue = [];
    this.root.fail = this.root;
    queue.push(this.root);

    while (queue.length > 0) {
      const cur = queue.shift();

      for (const [c, nextNode] of cur.children) {
        if (cur === this.root) {
          nextNode.fail = this.root;
        } else {
          let failure = cur.fail;

          while (failure !== this.root && !failure.children.has(c)) {
            failure = failure.fail;
          }

          if (failure.children.has(c)) {
            failure = failure.children.get(c);
          }

          nextNode.fail = failure;
        }

        if (nextNode.fail.isFinish) {
          nextNode.isFinish = true;
        }

        queue.push(nextNode);
      }
    }
  }

  find(text) {
    let cur = this.root;

    for (const c of text) {
      while (cur !== this.root && !cur.children.has(c)) {
        cur = cur.fail;
      }
      if (cur.children.has(c)) {
        cur = cur.children.get(c);
      }

      if (cur.isFinish) return true;
    }
    return false;
  }
}

const main = () => {
  const N = +readLine();

  const trie = new Trie();

  for (let i = 0 ; i < N ; i++) {
    trie.insert(readLine());
  }

  trie.failure();

  const Q = +readLine();

  let ans = Array.from({ length: Q }).map(() => {
    return trie.find(readLine()) ? 'YES' : 'NO';
  }).join('\n');

  console.log(ans);
}

main();
