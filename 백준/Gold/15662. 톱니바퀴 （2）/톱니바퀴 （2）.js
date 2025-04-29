const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function main () {
    const T = parseInt(input[0]);

    const gear = Array.from({ length: T }, () => Array(8).fill(0));

    for (let i = 0 ; i < T ; i++) {
        const line = input[i + 1].split('').map(Number);

        for (let j = 0 ; j < 8 ; j++) {
            gear[i][j] = line[j];
        }
    }

    const K = parseInt(input[T + 1]);

    for (let i = T + 2 ; i < T + K + 2 ; i++) {
        const [ N, D ] = input[i].split(' ').map(Number);

        // 회전시킬 톱니바퀴 기준으로 왼쪽
        rotate1(gear, N - 1, D);
        // 회전시킬 톱니바퀴 기준으로 오른쪽
        rotate2(gear, N - 1, D);

        // 마자막으로 현재 톱니바퀴 돌리기
        // D === 1이면 시계 방향이니까
        if (D === 1) {
            const now = gear[N - 1].pop();
            gear[N - 1].unshift(now);
        } else {
            const now = gear[N - 1].shift();
            gear[N - 1].push(now);
        }
    }

    let ans = 0;

    for (let i = 0 ; i < T ; i++) {
        if (gear[i][0] === 1) ans++;
    }

    console.log(ans);
}

// 선택된 톱니바퀴 왼쪽에 있는 톱니바퀴 회전
function rotate1 (arr, index, d) {
    // index가 범위 밖으로 넘어가거나 이전 톱니바퀴의 2번째와 현재 톱니바퀴의 6번째가 같지 않으면 다음 톱니바퀴 돌아가지 않음
    if (index < 1 || arr[index - 1][2] === arr[index][6]) return;

    // 그 다음 톱니바퀴 먼저 확인, 방향은 반대로
    rotate1(arr, index - 1, d * -1);

    // 이전 톱니바퀴 회전
    // d === 1 이면 현재 톱니바퀴가 시계 방향이니까 이전 톱니바퀴는 반시계 방향으로 돌려야됨
    // 반시계 방향은 맨 앞에 잘라서 제일 뒤로
    if (d === 1) {
        const now = arr[index - 1].shift();
        arr[index - 1].push(now);
    } else {
        const now = arr[index - 1].pop();
        arr[index - 1].unshift(now);
    }
}

// 선택된 톱니바퀴 오른쪽에 있는 톱니바퀴 회전
function rotate2 (arr, index, d) {
    // index가 범위 밖으로 넘어가거나 다음 톱니바퀴의 6번째와 현재 톱니바퀴의 2번째가 같지 않으면 다음 톱니바퀴 돌아가지 않음
    if (index >= arr.length - 1 || arr[index][2] === arr[index + 1][6]) return;

    rotate2(arr, index + 1, d * -1);

    // 다음 톱니바퀴 회전
    // d === 1 이면 현재 톱니바퀴가 시계 방향이니까 다음 톱니바퀴는 반시계 방향으로 돌아야됨
    if (d === 1) {
        const now = arr[index + 1].shift();
        arr[index + 1].push(now);
    } else {
        const now = arr[index + 1].pop();
        arr[index + 1].unshift(now);
    }
}


main();