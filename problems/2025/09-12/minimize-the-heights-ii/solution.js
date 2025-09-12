function minimizeHeights(arr, k) {
  const n = arr.length;
  if (n <= 1) return 0;
  arr.sort((a, b) => a - b);
  let ans = arr[n - 1] - arr[0];
  let small = arr[0] + k;
  let big = arr[n - 1] - k;
  if (small > big) [small, big] = [big, small];
  for (let i = 1; i <= n - 2; i++) {
    const decrease = arr[i] - k;
    const increase = arr[i] + k;
    if (decrease < 0) continue;
    const curMin = Math.min(small, decrease);
    const curMax = Math.max(big, increase);
    ans = Math.min(ans, curMax - curMin);
  }
  return ans;
}

console.log(minimizeHeights([1, 5, 8, 10], 2)); // 5
console.log(minimizeHeights([3, 9, 12, 16, 20], 3)); // 11


