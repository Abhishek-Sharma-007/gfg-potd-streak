# Gas Station

Given arrays gas[] and cost[] on a circle, find the starting index to complete the circuit once (clockwise) with unlimited tank but starting empty, or return -1 if impossible.

## Approach (Greedy, single pass)
- If sum(gas) < sum(cost), impossible → return -1.
- Traverse stations, maintaining tank += gas[i] - cost[i].
  - If tank drops below 0 at i, the start cannot be any index ≤ i; set start = i+1, reset tank = 0.
- Return start.

Time: O(n), Space: O(1).

