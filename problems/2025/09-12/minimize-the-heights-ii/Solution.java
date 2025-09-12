import java.util.*;
public class Solution {
    public static int minimizeHeights(int[] arr, int k) {
        int n = arr.length;
        if (n <= 1) return 0;
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n-1] - k;
        if (small > big) { int tmp = small; small = big; big = tmp; }
        for (int i = 1; i <= n - 2; i++) {
            int decrease = arr[i] - k;
            int increase = arr[i] + k;
            if (decrease < 0) continue;
            int curMin = Math.min(small, decrease);
            int curMax = Math.max(big, increase);
            ans = Math.min(ans, curMax - curMin);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(minimizeHeights(new int[]{1,5,8,10}, 2)); // 5
        System.out.println(minimizeHeights(new int[]{3,9,12,16,20}, 3)); // 11
    }
}


