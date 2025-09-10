# Largest number in one swap

Given a numeric string `s`, return the lexicographically largest string obtainable by swapping at most one pair of characters.

## Examples
- `s = "768"` → `"867"` (swap indices 0 and 2)
- `s = "333"` → `"333"` (no beneficial swap)

Constraints: `1 ≤ |s| ≤ 1e5`, characters in `'0'..'9'`.

## Approach (Rightmost maximum per suffix)
- Precompute for each index `i` the position `posMax[i]` of the maximum digit in the suffix `s[i..n-1]`. In ties, prefer the rightmost index to enable the lexicographically largest result.
- Scan from left to right; for the first position `i` where `s[posMax[i]] > s[i]`, swap `s[i]` with `s[posMax[i]]` and return.
- If no such position exists, `s` is already optimal.

Why rightmost? Among equal maximum digits in the suffix, swapping with the farthest-right occurrence preserves earlier digits and yields the lexicographically largest string.

## Complexity
- Time: `O(n)` after `O(n)` preprocessing.
- Space: `O(n)` for suffix maximum positions (can be reduced to `O(1)` by single pass from the right while scanning left-to-right carefully).

## Key terms & data structures
- **Lexicographic order**: string comparison left-to-right.
- **Suffix maximum**: track max digit position for each suffix.

## Language notes
- **Python**: store `posMax` and operate on a list of chars for swapping.
- **Java**: use `char[]` for in-place swap; precompute `posMax` with indices.
- **JavaScript**: strings are immutable; convert to array, swap, then `join`.
