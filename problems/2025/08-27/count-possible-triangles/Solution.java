import java.util.*;
public class Solution {
    public static long countTriangles(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;
        Arrays.sort(arr);
        long count = 0;
        for (int k = n-1; k >= 2; k--) {
            int i = 0, j = k-1;
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);
                    j--;
                } else i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countTriangles(new int[]{4,6,3,7})); // 3
        System.out.println(countTriangles(new int[]{10,21,22,100,101,200,300})); // 6
        System.out.println(countTriangles(new int[]{1,2,3})); // 0
    }
}


