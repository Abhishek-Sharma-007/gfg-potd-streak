import java.util.*;
public class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Arrays.fill(prev, -1);
        Arrays.fill(next, n);
        Deque<Integer> st = new ArrayDeque<>();
        // previous smaller (strict)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        // next smaller (strict)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int length = next[i] - prev[i] - 1; // window size
            int idx = length - 1;
            res[idx] = Math.max(res[idx], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) res[i] = Math.max(res[i], res[i + 1]);
        ArrayList<Integer> out = new ArrayList<>(n);
        for (int v : res) out.add(v);
        return out;
    }
}
