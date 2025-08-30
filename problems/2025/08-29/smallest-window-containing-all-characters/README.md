# Smallest window containing all characters

Given two strings `s` and `p`, find the smallest substring in `s` that contains all characters of `p` (including duplicates). If multiple windows have the same minimal length, choose the one with the smallest starting index. If none exists, return an empty string.

## Approach (Sliding Window + Frequency counts)
- Maintain required counts for characters in `p`.
- Expand the window with `right`, decreasing the remaining requirement when a useful character is included.
- When the window satisfies all requirements, try to shrink from `left` to minimize length while staying valid.
- Track best window `[bestL, bestR]`.

Time: O(n) where n = |s|; Space: O(1) for fixed alphabet (26 lowercase letters).

## Examples
- s = "timetopractice", p = "toc" → "toprac"
- s = "zoomlazapzo", p = "oza" → "apzo"
- s = "zoom", p = "zooe" → ""


