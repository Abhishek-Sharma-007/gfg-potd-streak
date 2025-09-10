# Count the number of possible triangles
Given arr[], count how many triplets (i<j<k) form valid triangles. Triangle condition: in sorted order, `arr[i] + arr[j] > arr[k]`.

## Approach
Sort the array. For each `k` from 2..n-1 as the largest side, use two pointers `i=0`, `j=k-1`:
- If `arr[i] + arr[j] > arr[k]`, then for all indices in `[i..j-1]` with `j`, triangles are valid → add `(j - i)`, then `j--`.
- Else `i++`.
- Time: `O(n^2)`; Space: `O(1)` extra.

## Key terms & data structures
- **Triangle inequality**: sum of any two sides > third.
- **Sorting**: enables two-pointer counting.
- **Two pointers**: count many combinations in linear time per `k`.

## Language notes
- **Python**: `arr.sort()` is `O(n log n)`; use integers (no overflow for given constraints).
- **Java**: `Arrays.sort(arr)`; watch `int` vs `long` only if constraints were larger.
- **JavaScript**: `arr.sort((a,b)=>a-b)` to avoid lexicographic sort.


