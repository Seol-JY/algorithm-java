import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #7569 토마토
    url : https://www.acmicpc.net/problem/7569
*/

public class Main {
    static int[][][] storage;
    static Queue<TomatoPos> queue = new LinkedList<>();
    static int h, n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        storage = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    storage[i][j][k] = Integer.parseInt(st.nextToken());
                    if (storage[i][j][k] == 1) {
                        queue.offer(new TomatoPos(i, j, k));
                    }
                }
            }
        }

        int result = bfs() - 1;

        Loop: for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (storage[i][j][k] == 0) {
                        result = -1;
                        break Loop;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs() {
        int zPos = 0; int xPos = 0; int yPos = 0;
        int[] dz = { -1, 0, 0, 0, 0, 1 };
        int[] dy = { 0, 0, 0, -1, 1, 0 };
        int[] dx = { 0, -1, 1, 0, 0, 0, };

        while (!queue.isEmpty()) {
            TomatoPos tomatoPos = queue.poll();
            zPos = tomatoPos.getZPos();
            xPos = tomatoPos.getXPos();
            yPos = tomatoPos.getYPos();

            for (int i = 0; i < 6; i++) {
                int nz = zPos + dz[i];
                int nx = xPos + dx[i];
                int ny = yPos + dy[i];

                if (nx < n && ny < m && nz < h && nx >= 0 && ny >= 0 && nz >= 0) {
                    if (storage[nz][nx][ny] == 0) {
                        queue.offer(new TomatoPos(nz, nx, ny));
                        storage[nz][nx][ny] = storage[zPos][xPos][yPos] + 1;
                    }
                }
            }
        }

        return storage[zPos][xPos][yPos];
    }

}

class TomatoPos {
    private final int zPos;
    private final int xPos;
    private final int yPos;

    public TomatoPos(int zPos, int xPos, int yPos) {
        this.zPos = zPos;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getZPos() {
        return zPos;
    }
}