import java.util.*;
class SpecialQueue {
    private Deque<Integer> q = new ArrayDeque<>();
    private Deque<Integer> minQ = new ArrayDeque<>();
    private Deque<Integer> maxQ = new ArrayDeque<>();

    public SpecialQueue() {}

    public void enqueue(int x) {
        q.addLast(x);
        while (!minQ.isEmpty() && minQ.peekLast() > x) minQ.pollLast();
        minQ.addLast(x);
        while (!maxQ.isEmpty() && maxQ.peekLast() < x) maxQ.pollLast();
        maxQ.addLast(x);
    }

    public void dequeue() {
        int x = q.removeFirst();
        if (!minQ.isEmpty() && minQ.peekFirst() == x) minQ.removeFirst();
        if (!maxQ.isEmpty() && maxQ.peekFirst() == x) maxQ.removeFirst();
    }

    public int getFront() { return q.peekFirst(); }
    public int getMin() { return minQ.peekFirst(); }
    public int getMax() { return maxQ.peekFirst(); }
}
