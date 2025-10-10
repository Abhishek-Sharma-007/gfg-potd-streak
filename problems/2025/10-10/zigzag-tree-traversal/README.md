# ZigZag Tree Traversal

Level order traversal with alternating direction: left→right on odd levels, right→left on even levels.

## Approach (BFS by levels)
- Standard BFS with a queue.
- For each level, collect node values into a list; if `reverse` flag is on, append them reversed.
- Toggle `reverse` each level.

Time: O(n), Space: O(n).
