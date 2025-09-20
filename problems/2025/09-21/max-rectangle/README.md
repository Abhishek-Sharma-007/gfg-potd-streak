# Max rectangle

Given a binary matrix `mat`, find the area of the largest rectangle containing only 1s.

## Approach (histogram per row)
Treat each row as the base of a histogram: accumulate consecutive ones in `heights[j]` for each column. For every row, compute the Largest Rectangle in Histogram (LRH) using a monotonic stack in O(cols). Track the maximum over all rows.

Time: O(rows * cols), Space: O(cols).
