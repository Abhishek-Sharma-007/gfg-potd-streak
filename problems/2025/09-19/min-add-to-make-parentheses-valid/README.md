# Min Add to Make Parentheses Valid

Given a string `s` consisting only of '(' and ')', return the minimum number of parentheses that must be inserted to make `s` a valid parentheses string.

A valid parentheses string has all '(' matched with ')', properly nested.

## Approach (single pass)
- Maintain `openNeeded` = number of unmatched '(' currently open.
- Maintain `insertions` = number of '(' we need to insert due to unmatched ')'.
- For each character:
  - If '(': `openNeeded++`.
  - If ')': if `openNeeded > 0` then `openNeeded--`; else `insertions++` (we need to add an opening '(' before it).
- At the end, answer is `insertions + openNeeded` (unmatched '(' need ')' insertions).

Time: O(n), Space: O(1).
