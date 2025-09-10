# The Celebrity Problem

A celebrity is a person who is known to all but does not know anyone at a party. Given an `n x n` matrix `mat`, where `mat[i][j] == 1` means person `i` knows person `j` (and `mat[i][i] == 1`), return the index of the celebrity if one exists, else `-1`.

## Approach (Two-pointer elimination + Verification)
- Use two pointers `i=0`, `j=n-1`.
  - If `mat[i][j] == 1`, then `i` knows `j` → `i` cannot be a celebrity → `i++`.
  - Else `j` cannot be a celebrity → `j--`.
- The remaining index `cand` is the only possible celebrity.
- Verify `cand`:
  - For all `k != cand`: `mat[cand][k] == 0` and `mat[k][cand] == 1`.

Time: O(n) for elimination + O(n) for verification → O(n)

## Examples
- `[[1,1,0],[0,1,0],[0,1,1]]` → `1`
- `[[1,1],[1,1]]` → `-1`
- `[[1]]` → `0`

## Key terms & data structures
- **Directed graph**: adjacency matrix of "knows" relation.
- **Candidate elimination**: two-pointer pass narrows possible celebrity to one.

## Language notes
- **Python**: matrix as `List[List[int]]`; nested loops for verification.
- **Java**: index into `int[][]`; avoid autoboxing overhead.
- **JavaScript**: arrays of arrays; strict equality checks.


