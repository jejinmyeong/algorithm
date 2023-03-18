function solution(weights) {
  var answer = 0;
  
  let map = new Map();
  
  for (let i = 0 ; i < weights.length; i++) {
      let now = weights[i];
      if (map.has(now)) answer += map.get(now);
      if (map.has(now * 2)) answer += map.get(now * 2);
      if (map.has(now / 2)) answer += map.get(now / 2);
      if (map.has(now * 2 / 3)) answer += map.get(now * 2 / 3);
      if (map.has(now * 3 / 2)) answer += map.get(now * 3 / 2);
      if (map.has(now * 3 / 4)) answer += map.get(now * 3 / 4);
      if (map.has(now * 4 / 3)) answer += map.get(now * 4 / 3);

      if (map.has(now)) map.set(now, map.get(now) + 1);
      else map.set(now, 1);
  }
  
  return answer;
}

solution([100,180,360,100,270])