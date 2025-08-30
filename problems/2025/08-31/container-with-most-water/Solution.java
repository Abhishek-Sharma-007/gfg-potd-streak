import java.util.*;

public class Solution {
    public static int maxArea(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;
        int left = 0, right = n - 1;
        int best = 0;
        while (left < right) {
            int height = Math.min(arr[left], arr[right]);
            int area = (right - left) * height;
            if (area > best) best = area;
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,5,4,3}));            // 6
        System.out.println(maxArea(new int[]{3,1,2,4,5}));          // 12
        System.out.println(maxArea(new int[]{2,1,8,6,4,6,5,5}));    // 25
    }
}


