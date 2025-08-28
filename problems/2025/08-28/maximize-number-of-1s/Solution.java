import java.util.*;

public class Solution {
    public static int maxConsecutiveOnes(int[] arr, int k) {
        int left = 0, zeros = 0, best = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) zeros++;
            while (zeros > k) {
                if (arr[left] == 0) zeros--;
                left++;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(new int[]{1,0,1}, 1));                   // 3
        System.out.println(maxConsecutiveOnes(new int[]{1,0,0,1,0,1,0,1}, 2));         // 5
        System.out.println(maxConsecutiveOnes(new int[]{1,1}, 2));                      // 2
    }
}
