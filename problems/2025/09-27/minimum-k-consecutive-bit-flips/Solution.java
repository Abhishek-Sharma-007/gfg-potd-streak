import java.util.*;
public class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int[] hint = new int[n];
        int flip = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) flip ^= hint[i - k];
            int bit = arr[i] ^ flip;
            if (bit == 0) {
                if (i + k > n) return -1;
                ans++;
                flip ^= 1;
                hint[i] = 1;
            }
        }
        return ans;
    }
}
