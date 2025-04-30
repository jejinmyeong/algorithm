const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const N = parseInt(input[0]);
    const visited = Array.from({ length: 101 }, () => Array(101).fill(false));

    for (let i = 1 ; i <= N ; i++) {
        const [ x, y, d, g ] = input[i].split(' ').map(Number);

        draw(x, y, getDirections(d, g), visited);
    }

    
    console.log(getNumberOfSquares(visited));
}

function getDirections(d, g) {
    const directions = [];
    directions.push(d);

    while (g-- > 0) {
        const len = directions.length - 1;
        for (let i = len ; i >= 0 ; i--) {
            let direction = (directions[i] + 1) % 4;
            directions.push(direction);
        }
    }

    return directions;
}

function draw (x, y, directions, visited) {
    visited[x][y] = true;

    for (let d of directions) {
        if (d === 0) {
            x += 1
        } else if (d === 1) {
            y -= 1
        } else if (d === 2) {
            x -= 1
        } else {
            y += 1
        }

        visited[x][y] = true;
    }
}

function getNumberOfSquares(visited) {
    let cnt = 0;

    for (let i = 0 ; i < 100 ; i++) {
        for (let j = 0 ; j < 100 ; j++) {
            if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) cnt++;
        }
    }

    return cnt;
}


main();