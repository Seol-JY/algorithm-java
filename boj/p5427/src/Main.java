import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #5427 불
    url : https://www.acmicpc.net/problem/5427
*/

public class Main {
    static int width, height;
    static char map[][];
    static Queue<Point> queue;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean visit[][];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int x = 0, y = 0;

        for(int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            map = new char[height][width];
            queue = new LinkedList<>();

            for(int i = 0; i < height; i++) {
                String line = br.readLine();
                for(int j = 0; j < width; j++) {
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                    else if(map[i][j] == '*')
                        queue.add(new Point(i, j));
                }
            }
            escape(x, y);
        }
        System.out.println(sb.toString());
    }

    public static void escape(int sx, int sy) {
        Queue<Point> q = new LinkedList<>();
        visit = new boolean[height][width];
        visit[sx][sy] = true;
        q.offer(new Point(-1, -1));
        q.offer(new Point(sx, sy));
        int time = -1;

        while(!q.isEmpty()) {
            Point now = q.poll();

            if(now.getXPos() == -1 && now.getYPos() == -1) {
                burn();
                if(!q.isEmpty())
                    q.offer(now);
                time++;
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.getXPos() + dx[i];
                int ny = now.getYPos() + dy[i];

                if(nx >= height || ny >= width || nx < 0 || ny < 0) {
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
        int size = queue.size();

        for(int i = 0; i < size; i++) {
            Point now = queue.poll();

            for (int j = 0; j < 4; j++) {
                int nx = now.getXPos() + dx[j];
                int ny = now.getYPos()+ dy[j];

                if(nx >= 0 && ny >= 0 && nx < height && ny < width && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                    queue.offer(new Point(nx, ny));
                    map[nx][ny] = '*';
                }
            }
        }
    }

    static class Point {
        private final int xPos, yPos;

        Point(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

        public int getXPos() {
            return xPos;
        }

        public int getYPos() {
            return yPos;
        }
    }
}