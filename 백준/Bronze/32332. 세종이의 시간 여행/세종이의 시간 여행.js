var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');

function main() {
    let [ cur, next ] = input;

    let [ Y0, M0, D0, T0, P0 ] = cur.split(' ');
    let [ Y1, M1, D1, T1, P1 ] = next.split(' ');

    let D = D0 * 2 - D1;
    let M = D <= 0 ? M0 * 2 - M1 - 1 : D > 30 ? M0 * 2 - M1 + 1 : M0 * 2 - M1;
    let Y = M <= 0 ? Y0 * 2 - Y1 - 1 : M > 12 ? Y0 * 2 - Y1 + 1 : Y0 * 2 - Y1;

    let T = (T0 * 2 - T1).toFixed(3);
    let P = (P0 * 2 - P1).toFixed(3);

    console.log(Y + " " + (M <= 0 ? 12 + M : M > 12 ? M - 12 : M) + " " + (D <= 0 ? 30 + D : D > 30 ? D - 30 : D) + " " + T + " " + P);
}

main();