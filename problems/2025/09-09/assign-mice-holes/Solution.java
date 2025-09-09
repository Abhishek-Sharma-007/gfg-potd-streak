import java.util.*;

public class Solution {
    public int assignHole(int[] mices, int[] holes) {
        int n = mices.length;
        if (n == 0) return 0;
        Arrays.sort(mices);
        Arrays.sort(holes);
        int best = 0;
        for (int i = 0; i < n; i++) {
            int d = Math.abs(mices[i] - holes[i]);
            if (d > best) best = d;
        }
        return best;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.assignHole(new int[]{4,-4,2}, new int[]{4,0,5})); // 4
        System.out.println(s.assignHole(new int[]{1,2}, new int[]{20,10}));     // 18
    }
}
