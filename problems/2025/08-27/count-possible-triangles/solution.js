function countTriangles(arr) {
  const n = arr.length;
  if (n < 3) return 0;
  arr.sort((a,b)=>a-b);
  let count = 0;
  for (let k = n-1; k >= 2; k--) {
    let i = 0, j = k-1;
    while (i < j) {
      if (arr[i] + arr[j] > arr[k]) { count += (j - i); j--; }
      else { i++; }
    }
  }
  return count;
}
console.log(countTriangles([4,6,3,7]));                          // 3
console.log(countTriangles([10,21,22,100,101,200,300]));         // 6
console.log(countTriangles([1,2,3]));                            // 0


