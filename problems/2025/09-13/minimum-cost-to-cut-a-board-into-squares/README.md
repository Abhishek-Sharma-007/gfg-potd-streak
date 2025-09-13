# Minimum Cost to cut a board into squares

Given a board of size n×m, costs for vertical cuts x[] (length-wise) and horizontal cuts y[] (width-wise) are provided. Each cut splits existing segments, so the cost of a vertical cut is cost_x × (current horizontal segments), and the cost of a horizontal cut is cost_y × (current vertical segments).

Goal: Minimize the total cost to obtain unit squares.

## Approach (Greedy)
- Sort both x and y in descending order.
- Maintain hSegments = 1 and vSegments = 1.
- Repeatedly take the larger next cut:
  - If next x is larger, make a vertical cut: add x[i] × hSegments, increment vSegments.
  - Else, make a horizontal cut: add y[j] × vSegments, increment hSegments.
- Finish remaining cuts similarly.

This maximizes each expensive cut's multiplier early, minimizing total.

Time: O((n+m) log(n+m)) for sorting, Space: O(1) extra.

