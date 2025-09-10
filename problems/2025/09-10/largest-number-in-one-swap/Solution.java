public class Solution {
    public String largestOneSwap(String s) {
        int n = s.length();
        if (n <= 1) return s;

        int[] posMax = new int[n];
        posMax[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) > s.charAt(posMax[i + 1])) posMax[i] = i;
            else if (s.charAt(i) < s.charAt(posMax[i + 1])) posMax[i] = posMax[i + 1];
            else posMax[i] = posMax[i + 1];
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int j = posMax[i];
            if (arr[j] > arr[i]) {
                char t = arr[i]; arr[i] = arr[j]; arr[j] = t;
                break;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestOneSwap("768"));   // 867
        System.out.println(s.largestOneSwap("333"));   // 333
        System.out.println(s.largestOneSwap("12345")); // 52341
    }
}
