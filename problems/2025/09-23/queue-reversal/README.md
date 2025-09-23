# Queue Reversal

Reverse the order of elements in a queue `q`.

Constraints: up to 1e3 elements.

## Approaches

- Iterative with auxiliary stack (recommended):
  1) Dequeue elements into a stack; 2) Pop stack back into queue. The last-in from the stack becomes the new front.
  - Time: O(n)
  - Extra space: O(n)

- Recursive (no explicit stack):
  - Recurse until the queue is empty, then on unwinding, enqueue elements back. Uses call stack O(n); beware recursion limits.

## Language notes

- Python: use `collections.deque` for O(1) `popleft()` / `append()`.
- Java: use `Queue<Integer>` with `ArrayDeque<>` and a `Deque<Integer>` as stack.
- JavaScript: if using plain arrays, `shift()` is O(n); acceptable for 1e3. A simple array stack is fine.
- C++: `std::queue<int>` and `std::stack<int>` from `<queue>` and `<stack>`.

Below are idiomatic stack-based solutions in all four languages.
