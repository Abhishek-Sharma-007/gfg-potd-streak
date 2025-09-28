import java.util.*;
public class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        Deque<Integer> maxDQ = new ArrayDeque<>();
        Deque<Integer> minDQ = new ArrayDeque<>();
        int bestLen = 0, bestL = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            while (!maxDQ.isEmpty() && arr[maxDQ.peekLast()] < arr[r]) maxDQ.pollLast();
            maxDQ.addLast(r);
            while (!minDQ.isEmpty() && arr[minDQ.peekLast()] > arr[r]) minDQ.pollLast();
            minDQ.addLast(r);
            while (!maxDQ.isEmpty() && !minDQ.isEmpty() && arr[maxDQ.peekFirst()] - arr[minDQ.peekFirst()] > x) {
                if (maxDQ.peekFirst() == l) maxDQ.pollFirst();
                if (minDQ.peekFirst() == l) minDQ.pollFirst();
                l++;
            }
            int curLen = r - l + 1;
            if (curLen > bestLen) { bestLen = curLen; bestL = l; }
        }
        ArrayList<Integer> res = new ArrayList<>(bestLen);
        for (int i = bestL; i < bestL + bestLen; i++) res.add(arr[i]);
        return res;
    }
}
