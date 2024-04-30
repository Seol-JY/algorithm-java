
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

/*
    solved BAEKJOON #2146 다리 만들기
    url : https://www.acmicpc.net/problem/2146
*/

public class p2146 {
    static int n, islandIndex;
    static int[][] map, group;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        group = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandIndex++;
                    indexingIsland(i, j);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= islandIndex; i++) {
            ans = Math.min(ans, bfs(i));
        }

        System.out.println(ans);
    }

    static int bfs(int start) {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] == start) {
                    q.offer(new Point(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isImmovable(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                
                if (group[nx][ny] != 0) {
                    return cur.dist;
                }

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, cur.dist + 1));
            }
        }

        return 0;
    }

    static void indexingIsland(int sx, int sy) {
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(sx, sy));
        visited[sx][sy] = true;
        group[sx][sy] = islandIndex;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isImmovable(nx, ny)) continue;
                if (map[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                group[nx][ny] = islandIndex;
                q.offer(new Point(nx, ny));
            }
        }
    }

    static boolean isImmovable(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= n);
    }

    static class Point {
        int x, y, dist;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
