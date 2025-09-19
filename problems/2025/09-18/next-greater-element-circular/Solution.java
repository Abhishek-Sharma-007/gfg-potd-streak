import java.util.*;
public class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        Deque<Integer> st = new ArrayDeque<>(); // indices
        for (int i = 2 * n - 1; i >= 0; i--) {
            int j = i % n;
            while (!st.isEmpty() && arr[st.peek()] <= arr[j]) st.pop();
            if (i < n && !st.isEmpty()) ans.set(j, arr[st.peek()]);
            st.push(j);
        }
        return ans;
    }
}

