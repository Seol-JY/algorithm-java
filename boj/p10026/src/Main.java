import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #10026 적록색약
    url : https://www.acmicpc.net/problem/10026
*/

public class Main {

    static int w, h;
    static char map[][];
    static Queue<Point> fire;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean visit[][];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int x = 0, y = 0;

        for(int t = 0; t < tc; t++) {
            stz = new StringTokenizer(br.readLine());
            w = Integer.parseInt(stz.nextToken());
            h = Integer.parseInt(stz.nextToken());
            map = new char[h][w];
            fire = new LinkedList<>();

            for(int i = 0; i < h; i++) {
                String line = br.readLine();
                for(int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                    else if(map[i][j] == '*')
                        fire.add(new Point(i, j));
                }
            }
            escape(x, y);
        }
        System.out.println(sb.toString());
    }

    public static void escape(int sx, int sy) {
        Queue<Point> q = new LinkedList<>();
        visit = new boolean[h][w];
        visit[sx][sy] = true;
        q.offer(new Point(-1, -1));
        q.offer(new Point(sx, sy));
        int time = -1;

        while(!q.isEmpty()) {
            Point now = q.poll();

            if(now.x == -1 && now.y == -1) {
                burn();
                if(!q.isEmpty())
                    q.offer(now);
                time++;
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= h || ny >= w || nx < 0 || ny < 0) {
                    sb.append(time+1 + "\n");
                    return;
                }
                if(map[nx][ny] == '.' && !visit[nx][ny]) {
                    q.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }

        sb.append("IMPOSSIBLE\n");
    }

    public static void burn() {
        int size = fire.size();

        for(int s = 0; s < size; s++) {
            Point now = fire.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < h && ny < w && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                    fire.offer(new Point(nx, ny));
                    map[nx][ny] = '*';
                }
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}