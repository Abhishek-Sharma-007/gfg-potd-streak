function minJumps(arr) {
  const n = arr.length;
  if (n <= 1) return 0;
  if (arr[0] === 0) return -1;

  let jumps = 0;
  let end = 0;
  let farthest = 0;

  for (let i = 0; i < n - 1; i++) {
    if (i > farthest) return -1;
    farthest = Math.max(farthest, i + arr[i]);
    if (i === end) {
      jumps++;
      end = farthest;
      if (end >= n - 1) return jumps;
    }
  }
  return end < n - 1 ? -1 : jumps;
}

// quick checks
console.log(minJumps([1,3,5,8,9,2,6,7,6,8,9])); // 3
console.log(minJumps([1,4,3,2,6,7]));           // 2
console.log(minJumps([0,10,20]));               // -1
