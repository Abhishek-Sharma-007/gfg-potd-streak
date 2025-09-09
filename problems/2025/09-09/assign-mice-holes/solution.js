function assignHole(mices, holes) {
  const n = mices.length;
  if (n === 0) return 0;
  mices = [...mices].sort((a, b) => a - b);
  holes = [...holes].sort((a, b) => a - b);
  let best = 0;
  for (let i = 0; i < n; i++) {
    const d = Math.abs(mices[i] - holes[i]);
    if (d > best) best = d;
  }
  return best;
}

// quick checks
console.log(assignHole([4, -4, 2], [4, 0, 5])); // 4
console.log(assignHole([1, 2], [20, 10]));      // 18
