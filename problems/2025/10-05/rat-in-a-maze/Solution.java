import java.util.*;
public class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        ArrayList<String> res = new ArrayList<>();
        if (n == 0 || maze[0][0] == 0 || maze[n-1][n-1] == 0) return res;
        boolean[][] vis = new boolean[n][n];
        dfs(0, 0, maze, vis, new StringBuilder(), res);
        Collections.sort(res);
        return res;
    }

    private void dfs(int r, int c, int[][] maze, boolean[][] vis, StringBuilder path, ArrayList<String> res) {
        int n = maze.length;
        if (r == n - 1 && c == n - 1) { res.add(path.toString()); return; }
        vis[r][c] = true;
        // order: D, L, R, U to match typical lexicographic path order
        // D
        if (r + 1 < n && maze[r+1][c] == 1 && !vis[r+1][c]) {
            path.append('D');
            dfs(r + 1, c, maze, vis, path, res);
            path.setLength(path.length() - 1);
        }
        // L
        if (c - 1 >= 0 && maze[r][c-1] == 1 && !vis[r][c-1]) {
            path.append('L');
            dfs(r, c - 1, maze, vis, path, res);
            path.setLength(path.length() - 1);
        }
        // R
        if (c + 1 < n && maze[r][c+1] == 1 && !vis[r][c+1]) {
            path.append('R');
            dfs(r, c + 1, maze, vis, path, res);
            path.setLength(path.length() - 1);
        }
        // U
        if (r - 1 >= 0 && maze[r-1][c] == 1 && !vis[r-1][c]) {
            path.append('U');
            dfs(r - 1, c, maze, vis, path, res);
            path.setLength(path.length() - 1);
        }
        vis[r][c] = false;
    }
}
