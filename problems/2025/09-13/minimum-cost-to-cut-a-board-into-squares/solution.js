function minCostToCutBoard(x, y) {
  x.sort((a, b) => b - a);
  y.sort((a, b) => b - a);
  let i = 0, j = 0;
  let hSegments = 1; // horizontal pieces count
  let vSegments = 1; // vertical pieces count
  let total = 0;
  while (i < x.length && j < y.length) {
    if (x[i] >= y[j]) {
      total += x[i] * hSegments;
      vSegments++;
      i++;
    } else {
      total += y[j] * vSegments;
      hSegments++;
      j++;
    }
  }
  while (i < x.length) {
    total += x[i] * hSegments;
    vSegments++;
    i++;
  }
  while (j < y.length) {
    total += y[j] * vSegments;
    hSegments++;
    j++;
  }
  return total;
}

console.log(minCostToCutBoard([2,1,3,1,4], [4,1,2])); // 42
console.log(minCostToCutBoard([1,1,1], [1,1,1]));     // 15


