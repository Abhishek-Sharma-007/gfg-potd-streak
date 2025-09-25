# Generate Binary Numbers 1..n

Generate binary representations of numbers from 1 to `n`.

## Approach (BFS on strings)
Use a queue seeded with "1". Repeatedly pop front `s`, output it, then push `s+"0"` and `s+"1"`. Do this `n` times.

Time: O(n), total output length O(n log n).
