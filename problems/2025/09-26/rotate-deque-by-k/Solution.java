import java.util.*;
public class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        if (n == 0) return;
        k %= n;
        if (k == 0) return;
        if (type == 1) { // right
            if (k > n - k) { // rotate left n-k
                int steps = n - k;
                while (steps-- > 0) dq.offerLast(dq.pollFirst());
            } else {
                int steps = k;
                while (steps-- > 0) dq.offerFirst(dq.pollLast());
            }
        } else { // left
            if (k > n - k) { // rotate right n-k
                int steps = n - k;
                while (steps-- > 0) dq.offerFirst(dq.pollLast());
            } else {
                int steps = k;
                while (steps-- > 0) dq.offerLast(dq.pollFirst());
            }
        }
    }
}
