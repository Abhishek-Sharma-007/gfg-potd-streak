import java.util.*;
public class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> res = new ArrayList<>(n);
        Deque<String> q = new ArrayDeque<>();
        q.add("1");
        for (int i = 0; i < n; i++) {
            String s = q.removeFirst();
            res.add(s);
            q.addLast(s + "0");
            q.addLast(s + "1");
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().generateBinary(6));
    }
}
