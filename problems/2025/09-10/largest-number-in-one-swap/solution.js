function largestOneSwap(s) {
  const n = s.length;
  if (n <= 1) return s;

  const posMax = new Array(n);
  posMax[n - 1] = n - 1;
  for (let i = n - 2; i >= 0; i--) {
    if (s[i] > s[posMax[i + 1]]) posMax[i] = i;
    else if (s[i] < s[posMax[i + 1]]) posMax[i] = posMax[i + 1];
    else posMax[i] = posMax[i + 1];
  }

  const arr = s.split("");
  for (let i = 0; i < n; i++) {
    const j = posMax[i];
    if (arr[j] > arr[i]) {
      const t = arr[i]; arr[i] = arr[j]; arr[j] = t;
      break;
    }
  }
  return arr.join("");
}

// quick checks
console.log(largestOneSwap("768"));  // 867
console.log(largestOneSwap("333"));  // 333
console.log(largestOneSwap("12345")); // 52341
