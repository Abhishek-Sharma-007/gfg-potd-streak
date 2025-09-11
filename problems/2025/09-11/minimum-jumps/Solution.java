public class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        int jumps = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            if (i > farthest) return -1;
            farthest = Math.max(farthest, i + arr[i]);
            if (i == end) {
                jumps++;
                end = farthest;
                if (end >= n - 1) return jumps;
            }
        }
        return end < n - 1 ? -1 : jumps;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minJumps(new int[]{1,3,5,8,9,2,6,7,6,8,9})); // 3
        System.out.println(s.minJumps(new int[]{1,4,3,2,6,7}));           // 2
        System.out.println(s.minJumps(new int[]{0,10,20}));               // -1
    }
}
