# Expression Add Operators

Insert '+', '-', '*' between digits of `s` to evaluate to `target`. Avoid operands with leading zeros (except '0'). Return expressions in lexicographic order.

## Approach (DFS with running value and last factor)
Backtrack over all splits of the next operand. Track:
- `expr`: current expression string
- `pos`: current index in `s`
- `eval`: evaluated value so far
- `last`: last multiplicative term (to handle '*': undo then add `last * cur`).

For each step, extend the next operand `cur` (as long as no leading zero unless single digit). If starting (`pos == 0`), seed with operand. Otherwise try '+', '-', and '*', updating `eval` and `last` accordingly.

Time: O(4^n) worst-case; n ≤ 9.
