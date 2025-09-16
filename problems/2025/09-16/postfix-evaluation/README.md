# Postfix Evaluation

Evaluate a valid Reverse Polish Notation (postfix) expression given as an array of tokens.

- Operands are integers in [-1e4, 1e4]
- Operators: +, -, *, /, ^
- Division is floor division (towards -infinity)
- Result and intermediates fit in 32-bit signed int

## Approach
Use a stack:
- For each token:
  - If number → push
  - Else pop b, then a, compute a op b and push back
- For /, use floor division. For ^, compute integer power.

Time: O(n), Space: O(n)
