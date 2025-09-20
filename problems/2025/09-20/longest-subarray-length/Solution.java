import java.util.*;
public class Solution {
    public static int longestSubarray(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> st = new ArrayDeque<>();
        // left: nearest greater strictly to the left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        // right: nearest greater strictly to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int span = right[i] - left[i] - 1;
            if (span >= arr[i]) ans = Math.max(ans, span);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,2,3}));    // 3
        System.out.println(longestSubarray(new int[]{6,4,2,5}));  // 0
    }
}
