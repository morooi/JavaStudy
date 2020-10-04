import java.util.Scanner;

public class Main {

    private static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            String[] nm = sc.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
            char[][] maze = new char[n][m];
            int x = 0, y = 0;
            boolean flag = true;
            for (int n1 = 0; n1 < n; n1++) {
                String[] next = sc.nextLine().split("");
                for (int m1 = 0; m1 < m; m1++) {
                    maze[n1][m1] = next[m1].charAt(0);
                    if (flag && maze[n1][m1] == '@') {
                        x = n1;
                        y = m1;
                        flag = false;
                    }
                }
            }
            res = Integer.MAX_VALUE;
            boolean[][] is = new boolean[n][m];
            helper(maze, x, y, 0, is);
            if (res == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(res);
        }
    }

    private static void helper(char[][] maze, int x, int y, int count, boolean[][] is) {
        int n = maze.length, m = maze[0].length;
        if (x >= n || x < 0 || y >= m || y < 0) {
            res = Math.min(res, count);
            return;
        }
        if (maze[x][y] == '#' || is[x][y]) return;
        if (maze[x][y] == '*') {
            count++;
        }
        is[x][y] = true;
        helper(maze, x + 1, y, count, is);
        helper(maze, x - 1, y, count, is);
        helper(maze, x, y + 1, count, is);
        helper(maze, x, y - 1, count, is);
        is[x][y] = false;
    }

}
