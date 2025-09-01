function sumOfModes(arr, k) {
  const n = arr.length;
  if (k <= 0 || k > n) return 0;

  // Binary heap (min-heap) of pairs [negFreq, val]
  const heap = [];
  const counts = new Map(); // val -> freq

  const less = (a, b) => {
    if (a[0] !== b[0]) return a[0] < b[0]; // negFreq smaller => larger freq
    return a[1] < b[1]; // tie by smaller value
  };

  const heapSwap = (i, j) => { const t = heap[i]; heap[i] = heap[j]; heap[j] = t; };
  const heapUp = (i) => {
    while (i > 0) {
      const p = (i - 1) >> 1;
      if (!less(heap[i], heap[p])) break;
      heapSwap(i, p); i = p;
    }
  };
  const heapDown = (i) => {
    const n = heap.length;
    while (true) {
      let l = i * 2 + 1, r = l + 1, m = i;
      if (l < n && less(heap[l], heap[m])) m = l;
      if (r < n && less(heap[r], heap[m])) m = r;
      if (m === i) break;
      heapSwap(i, m); i = m;
    }
  };
  const heapPush = (item) => { heap.push(item); heapUp(heap.length - 1); };
  const heapPop = () => {
    const last = heap.pop();
    if (heap.length === 0) return last;
    const top = heap[0];
    heap[0] = last; heapDown(0);
    return top;
  };
  const heapPeek = () => heap[0];

  const pushValue = (val, newFreq) => {
    heapPush([-newFreq, val]);
  };

  // Build first window
  for (let i = 0; i < k; i++) {
    const v = arr[i];
    const f = (counts.get(v) || 0) + 1;
    counts.set(v, f);
    pushValue(v, f);
  }

  const currentModeValue = () => {
    while (heap.length > 0) {
      const [negf, v] = heapPeek();
      const freq = counts.get(v) || 0;
      if (freq === -negf) return v;
      heapPop();
    }
    return 0;
  };

  let total = currentModeValue();

  // Slide window
  for (let r = k; r < n; r++) {
    const out = arr[r - k];
    const inn = arr[r];

    // Decrease outgoing
    const fOut = counts.get(out) || 0;
    if (fOut > 0) {
      const nf = fOut - 1;
      if (nf === 0) counts.delete(out);
      else { counts.set(out, nf); pushValue(out, nf); }
    }

    // Increase incoming
    const fIn = (counts.get(inn) || 0) + 1;
    counts.set(inn, fIn);
    pushValue(inn, fIn);

    total += currentModeValue();
  }

  return total | 0; // int-like
}

// quick checks
console.log(sumOfModes([1, 2, 3, 2, 5, 2, 4, 4], 3)); // 13
console.log(sumOfModes([1, 2, 1, 3, 5], 2));          // 6


