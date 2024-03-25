const fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');
// const input = fs.readFileSync('example.txt').toString().split('\n');

class Shark {
    constructor(x, y, d, sum) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.sum = sum;
    }
}

class Fish {
    constructor(x, y, idx, d, isAlive) {
        this.x = x;
        this.y = y;
        this.idx = idx;
        this.d = d;
        this.isAlive = isAlive;
    }
}

const D = [[-1, 0],[-1, -1],[0, -1],[1, -1],[1, 0],[1, 1],[0, 1],[-1, 1]];
let maxSum = 0;

function main() {
    let map = [];
    let fishes = [];

    for (let i = 0 ; i < 4 ; i++) {
        const line = input[i].split(' ');
        map.push([]);

        for (let j = 0 ; j < 4 ; j++) {
            let a = parseInt(line[j * 2]);
            let b = parseInt(line[j * 2 + 1] - 1);

            map[i].push(a);
            fishes.push(new Fish(i, j, a, b, true))
        }
    }

    fishes.sort((a, b) => a.idx - b.idx);

    const f = fishes[map[0][0] - 1];
    const shark = new Shark(0, 0, f.d, f.idx);
    f.isAlive = false;
    map[0][0] = -1;

    dfs(map, shark, fishes);
    console.log(maxSum);
}

function dfs(map, shark, fishes) {
    if (maxSum < shark.sum) {
        maxSum = shark.sum;
    }

    fishes.forEach((fish) => move(fish, map, fishes));

    for (let i = 1 ; i < 4 ; i++) {
        const nx = shark.x + D[shark.d][0] * i;
        const ny = shark.y + D[shark.d][1] * i;

        if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || map[nx][ny] <= 0) continue;

        let copyMap = map.map((v1) => v1.map(v2 => v2));
        let copyFishes = fishes.map(fish => new Fish(fish.x, fish.y, fish.idx, fish.d, fish.isAlive));

        copyMap[shark.x][shark.y] = 0;
        let f = copyFishes[map[nx][ny] - 1];
        f.isAlive = false;
        copyMap[f.x][f.y] = -1;

        dfs(copyMap, new Shark(f.x, f.y, f.d, shark.sum + f.idx), copyFishes);
    }
}

function move(fish, map, fishes) {
    if (!fish.isAlive) return;

    for (let d = 0 ; d < 8 ; d++) {
        let nd = (fish.d + d) % 8;
        let nx = fish.x + D[nd][0];
        let ny = fish.y + D[nd][1];

        if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || map[nx][ny] < 0) continue;

        map[fish.x][fish.y] = 0;

        if (map[nx][ny] === 0) {
            fish.x = nx;
            fish.y = ny;
        } else {
            let temp = fishes[map[nx][ny] - 1];
            temp.x = fish.x;
            temp.y = fish.y;
            map[fish.x][fish.y] = temp.idx;

            fish.x = nx;
            fish.y = ny;
        }

        map[nx][ny] = fish.idx;
        fish.d = nd;
        return;
    }
}

main();