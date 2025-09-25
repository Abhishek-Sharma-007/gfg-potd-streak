# Design MinMax Queue (SpecialQueue)

Queue with O(1) getMin/getMax.

## Idea
Maintain:
- main queue `Q` for FIFO order
- monotonic `minQ` (increasing): while enqueue(x), pop back while `minQ.back() > x`, then push x; on dequeue, if `front == minQ.front()`, pop front.
- monotonic `maxQ` (decreasing): while enqueue(x), pop back while `maxQ.back() < x`, then push x; on dequeue, if `front == maxQ.front()`, pop front.

All ops O(1) amortized.
