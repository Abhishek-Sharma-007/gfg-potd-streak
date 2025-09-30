import java.util.*;
public class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> res = new ArrayList<>();
        char[] cur = new char[n];
        dfs(0, n, cur, res);
        return res;
    }
    private void dfs(int i, int n, char[] cur, ArrayList<String> res) {
        if (i == n) { res.add(new String(cur)); return; }
        cur[i] = '0'; dfs(i+1, n, cur, res);
        cur[i] = '1'; dfs(i+1, n, cur, res);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().binstr(3));
    }
}
