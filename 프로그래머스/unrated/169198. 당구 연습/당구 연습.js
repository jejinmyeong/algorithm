function solution(m, n, startX, startY, balls) {
    var answer = [];
    
    for (let i = 0 ; i < balls.length ; i++) {
        let x = balls[i][0];
        let y = balls[i][1];
        const symmetry = [[x * -1, y],[x, y * -1],[(m - x) * 2 + x, y],[x, (n - y)*2 + y]];
        let temp = 987654321;
        for (let d = 0 ; d < 4 ; d++) {
            if (startX === x && startY > y && d === 1) continue; 
            else if (startY === y && startX > x && d === 0) continue;
            else if (startX === x && startY < y && d === 3) continue;
            else if (startY === y && startX < x && d === 2) continue;
            
            temp = Math.min(temp, Math.pow(startX - symmetry[d][0], 2) + Math.pow(startY - symmetry[d][1], 2));
        }
        answer.push(temp);
    }
    return answer;
}