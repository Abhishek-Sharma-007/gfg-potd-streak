function startStation(gas, cost) {
  const n = gas.length;
  let total = 0, tank = 0, start = 0;
  for (let i = 0; i < n; i++) {
    const diff = gas[i] - cost[i];
    total += diff;
    tank += diff;
    if (tank < 0) {
      start = i + 1;
      tank = 0;
    }
  }
  return total >= 0 ? start : -1;
}

console.log(startStation([4,5,7,4], [6,6,3,5])); // 2
console.log(startStation([3,9], [7,6])); // -1


