# Decode the string

Given an encoded string `s`, decode patterns of the form `k[substring]` where `substring` is repeated `k` times. Patterns can be nested; `k` is a positive integer; input uses lowercase English letters.

Examples:
- `3[b2[ca]]` → `bcacabcacabcaca`
- `3[ab]` → `ababab`

## Approach (stack)
Scan left to right using two stacks:
- number stack to store repetition counts
- string stack to store partial strings before `[`.
When we see `[`, push current count and current string, then reset them. When we see `]`, pop count and previous string, and append `count` copies of current into previous. Digits can be multi-digit.

Time: O(n), Space: O(n).
