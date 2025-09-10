# Check if a String is Subsequence of Other
Given strings s and t, return true if s is a subsequence of t (characters of s can appear in t in order, not necessarily contiguously).

## Approach
Two-pointer scan: walk `t` once; advance pointer in `s` when characters match. If we consume all of `s`, it is a subsequence.
- Time: `O(|s| + |t|)`
- Space: `O(1)`

## Key terms & data structures
- **Subsequence**: preserves order, not necessarily contiguity.
- **Two pointers**: synchronous scan over two strings; constant space.

## Language notes
- **Python**: iterate over `t`; keep index `i` in `s`. Early-exit when `i == len(s)`.
- **Java**: use `charAt` on `String` and integer indices; avoid building substrings.
- **JavaScript**: strings are immutable; use indexing `s[i]`; prefer for-of over building arrays.


