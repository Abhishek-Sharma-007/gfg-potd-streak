# Container With Most Water

Given an array `arr` of non-negative integers representing heights, choose two lines that, along with the x-axis, form a container holding the most water. Return the maximum area.

## Approach (Two pointers)
- Initialize `left=0`, `right=n-1`, `best=0`.
- At each step, compute `area = (right-left) * min(arr[left], arr[right])`, update `best`.
- Move the pointer with the smaller height inward (potential to find taller line and larger area).
- Continue until `left >= right`.

Time: O(n), Space: O(1)

## Examples
- `[1,5,4,3]` → `6`
- `[3,1,2,4,5]` → `12`
- `[2,1,8,6,4,6,5,5]` → `25`


