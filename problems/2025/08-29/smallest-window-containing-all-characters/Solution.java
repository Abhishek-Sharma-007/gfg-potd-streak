import java.util.*;

public class Solution {
    public static String smallestWindow(String s, String p) {
        if (p.length() == 0 || s.length() == 0 || p.length() > s.length()) return "";

        int[] need = new int[26];
        int requiredKinds = 0;
        for (char c : p.toCharArray()) {
            int idx = c - 'a';
            if (need[idx] == 0) requiredKinds++;
            need[idx]++;
        }

        int[] window = new int[26];
        int haveKinds = 0;
        int left = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestL = 0;

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            int rIdx = rc - 'a';
            if (rIdx >= 0 && rIdx < 26 && need[rIdx] > 0) {
                window[rIdx]++;
                if (window[rIdx] == need[rIdx]) haveKinds++;
            }

            while (haveKinds == requiredKinds) {
                int currLen = right - left + 1;
                if (currLen < bestLen) {
                    bestLen = currLen;
                    bestL = left;
                }
                char lc = s.charAt(left);
                int lIdx = lc - 'a';
                if (lIdx >= 0 && lIdx < 26 && need[lIdx] > 0) {
                    window[lIdx]--;
                    if (window[lIdx] < need[lIdx]) haveKinds--;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);
    }

    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice", "toc")); // toprac
        System.out.println(smallestWindow("zoomlazapzo", "oza"));    // apzo
        System.out.println(smallestWindow("zoom", "zooe"));          // ""
    }
}


