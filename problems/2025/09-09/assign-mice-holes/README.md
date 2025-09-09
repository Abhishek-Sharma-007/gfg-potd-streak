# Assign Mice Holes

Given two arrays `mices[]` and `holes[]` of equal size `n`, representing positions on a line. Each hole can take exactly one mouse. In one minute a mouse can move one step left or right. Assign each mouse to a distinct hole to minimize the time when the last mouse reaches its hole (i.e., minimize the maximum arrival time).

## Examples
- `mices = [4, -4, 2]`, `holes = [4, 0, 5]` → answer: `4`
  - Pair after sorting: `(−4,0) -> 4`, `(2,4) -> 2`, `(4,5) -> 1`, max = 4
- `mices = [1, 2]`, `holes = [20, 10]` → answer: `18`
  - Pairs: `(1,10) -> 9`, `(2,20) -> 18`, max = 18

Constraints: `1 ≤ n ≤ 1e5`, positions within `[−1e5, 1e5]`.

## Approach (Greedy + Sorting)
Sort both arrays in non-decreasing order and match the i-th mouse with the i-th hole. The maximum absolute difference among all pairs is the minimal possible final time.

Intuition: Sorting aligns mice and holes to avoid unnecessary long crossings, a standard exchange argument proves optimality.

## Complexity
- Time: `O(n log n)` due to sorting.
- Space: `O(1)` extra (ignoring sort's internal space).
