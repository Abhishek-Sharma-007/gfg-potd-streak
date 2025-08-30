function maxArea(arr) {
  const n = arr.length;
  if (n < 2) return 0;
  let left = 0, right = n - 1;
  let best = 0;
  while (left < right) {
    const height = Math.min(arr[left], arr[right]);
    const area = (right - left) * height;
    if (area > best) best = area;
    if (arr[left] < arr[right]) left++;
    else right--;
  }
  return best;
}

// quick checks
console.log(maxArea([1,5,4,3]));            // 6
console.log(maxArea([3,1,2,4,5]));          // 12
console.log(maxArea([2,1,8,6,4,6,5,5]));    // 25


