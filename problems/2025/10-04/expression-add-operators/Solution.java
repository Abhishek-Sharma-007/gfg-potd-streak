import java.util.*;
public class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> res = new ArrayList<>();
        dfs(s, target, 0, 0L, 0L, new StringBuilder(), res);
        Collections.sort(res);
        return res;
    }

    private void dfs(String s, int target, int pos, long eval, long last, StringBuilder expr, ArrayList<String> res) {
        int n = s.length();
        if (pos == n) {
            if (eval == target) res.add(expr.toString());
            return;
        }
        long cur = 0;
        int len0 = expr.length();
        for (int i = pos; i < n; i++) {
            // avoid leading zeros
            if (i > pos && s.charAt(pos) == '0') break;
            cur = cur * 10 + (s.charAt(i) - '0');
            if (pos == 0) {
                expr.append(cur);
                dfs(s, target, i + 1, cur, cur, expr, res);
                expr.setLength(len0);
            } else {
                // +
                expr.append('+').append(cur);
                dfs(s, target, i + 1, eval + cur, cur, expr, res);
                expr.setLength(len0);
                // -
                expr.append('-').append(cur);
                dfs(s, target, i + 1, eval - cur, -cur, expr, res);
                expr.setLength(len0);
                // *
                expr.append('*').append(cur);
                dfs(s, target, i + 1, eval - last + last * cur, last * cur, expr, res);
                expr.setLength(len0);
            }
        }
    }
}
