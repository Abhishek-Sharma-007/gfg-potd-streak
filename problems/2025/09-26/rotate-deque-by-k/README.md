# Rotate Deque By K

Rotate a `Deque<Integer>` by `k` steps: type=1 → right (clockwise), type=2 → left (anti-clockwise).

## Approach
Let `n = dq.size()`, reduce `k %= n`.
- Right: move last to front `k` times (`pollLast()` → `offerFirst()`)
- Left: move first to back `k` times (`pollFirst()` → `offerLast()`)

Alternatively, for efficiency, if `k > n/2`, rotate in the opposite direction by `n-k`.

Time: O(min(k, n-k)). Space: O(1).
