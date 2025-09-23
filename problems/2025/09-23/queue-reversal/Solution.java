import java.util.*;
public class Solution {
    public void reverseQueue(Queue<Integer> q) {
        Deque<Integer> st = new ArrayDeque<>();
        while (!q.isEmpty()) st.push(q.remove());
        while (!st.isEmpty()) q.add(st.pop());
    }
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>(Arrays.asList(5,10,15,20,25));
        new Solution().reverseQueue(q);
        System.out.println(q); // [25, 20, 15, 10, 5]
    }
}
