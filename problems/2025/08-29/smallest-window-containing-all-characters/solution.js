function smallestWindow(s, p) {
  if (!p || !s || p.length > s.length) return "";

  const need = new Array(26).fill(0);
  let requiredKinds = 0;
  for (const ch of p) {
    const idx = ch.charCodeAt(0) - 97;
    if (need[idx] === 0) requiredKinds++;
    need[idx]++;
  }

  const window = new Array(26).fill(0);
  let haveKinds = 0;
  let left = 0;
  let bestLen = Number.POSITIVE_INFINITY;
  let bestL = 0;

  for (let right = 0; right < s.length; right++) {
    const rIdx = s.charCodeAt(right) - 97;
    if (rIdx >= 0 && rIdx < 26 && need[rIdx] > 0) {
      window[rIdx]++;
      if (window[rIdx] === need[rIdx]) haveKinds++;
    }

    while (haveKinds === requiredKinds) {
      const currLen = right - left + 1;
      if (currLen < bestLen) {
        bestLen = currLen;
        bestL = left;
      }
      const lIdx = s.charCodeAt(left) - 97;
      if (lIdx >= 0 && lIdx < 26 && need[lIdx] > 0) {
        window[lIdx]--;
        if (window[lIdx] < need[lIdx]) haveKinds--;
      }
      left++;
    }
  }

  return bestLen === Number.POSITIVE_INFINITY ? "" : s.slice(bestL, bestL + bestLen);
}

// quick checks
console.log(smallestWindow("timetopractice", "toc")); // toprac
console.log(smallestWindow("zoomlazapzo", "oza"));    // apzo
console.log(smallestWindow("zoom", "zooe"));          // ""


