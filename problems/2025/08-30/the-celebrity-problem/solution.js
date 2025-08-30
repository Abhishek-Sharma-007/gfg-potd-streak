function celebrity(mat) {
  const n = mat.length;
  if (n === 0) return -1;

  let i = 0, j = n - 1;
  while (i < j) {
    if (mat[i][j] === 1) {
      i++;
    } else {
      j--;
    }
  }

  const cand = i;
  for (let k = 0; k < n; k++) {
    if (k === cand) continue;
    if (mat[cand][k] === 1 || mat[k][cand] === 0) return -1;
  }
  return cand;
}

// quick checks
console.log(celebrity([[1,1,0],[0,1,0],[0,1,1]])); // 1
console.log(celebrity([[1,1],[1,1]]));             // -1
console.log(celebrity([[1]]));                     // 0


