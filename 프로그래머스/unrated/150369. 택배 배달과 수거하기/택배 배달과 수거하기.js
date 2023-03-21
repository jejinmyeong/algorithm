function solution(cap, n, deliveries, pickups) {
    let num_deliveries = 0;
    let num_pickups = 0;
    let answer = 0;


    for (i = n - 1; i >= 0; i--) {
        let num_times = 0;
        deliveries[i] = deliveries[i] + num_deliveries;
        pickups[i] = pickups[i] + num_pickups;

        while (deliveries[i] > 0 || pickups[i] > 0) {
            deliveries[i] = deliveries[i] - cap;
            pickups[i] = pickups[i] - cap;
            num_times++;
        }

        num_deliveries = deliveries[i];
        num_pickups = pickups[i];
        
        if (deliveries[i] > 0 || pickups[i] > 0) {
            answer = answer + 2 * (i + 1) * (num_times + 1);
        } else {
            answer = answer + 2 * (i + 1) * (num_times);
        }


    }

    return answer;

}