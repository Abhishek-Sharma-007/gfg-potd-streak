import java.util.*;
public class Solution {
    static int maxArea(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[] heights = new int[c];
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                heights[j] = (mat[i][j] == 1) ? heights[j] + 1 : 0;
            }
            Deque<Integer> st = new ArrayDeque<>();
            for (int k = 0; k <= c; k++) {
                int h = (k < c) ? heights[k] : 0;
                while (!st.isEmpty() && heights[st.peek()] > h) {
                    int ht = heights[st.pop()];
                    int left = st.isEmpty() ? -1 : st.peek();
                    int width = k - left - 1;
                    ans = Math.max(ans, ht * width);
                }
                st.push(k);
            }
        }
        return ans;
    }
}
