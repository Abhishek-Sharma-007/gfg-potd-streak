# Minimum K Consecutive Bit Flips

Given a binary array `arr` and an integer `k`, you may flip all bits in any subarray of length `k`. Return the minimum flips to make all bits 1, or -1 if impossible.

## Approach (Greedy with sliding parity)
Maintain a running parity `flip` indicating whether the current index has been flipped odd times by previous windows. Keep an auxiliary `hint` array; when a flip starts at `i`, set `hint[i] = 1` and later when you move past `i + k - 1`, remove its effect by XORing `flip` with `hint[i-k]`.

For each index `i` from 0..n-1:
- If `i >= k`, do `flip ^= hint[i-k]` to drop an expired flip.
- If `(arr[i] ^ flip) == 0` (effective bit is 0), you must start a flip at `i`. If `i + k > n`, return -1. Otherwise set `hint[i] = 1`, `flip ^= 1`, and increment answer.

Time: O(n), Space: O(n).
