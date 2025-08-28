function maxConsecutiveOnes(arr, k) {
    let left = 0, zeros = 0, best = 0;
    for (let right = 0; right < arr.length; right++) {
      if (arr[right] === 0) zeros++;
      while (zeros > k) {
        if (arr[left] === 0) zeros--;
        left++;
      }
      best = Math.max(best, right - left + 1);
    }
    return best;
  }
  
  // quick checks
  console.log(maxConsecutiveOnes([1,0,1], 1));                 // 3
  console.log(maxConsecutiveOnes([1,0,0,1,0,1,0,1], 2));       // 5
  console.log(maxConsecutiveOnes([1,1], 2));                   // 2
  