import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #2573 빙산
    url : https://www.acmicpc.net/problem/2573
*/

public class p2573 {
    static final int dx[] = {-1,1,0,0};
    static final int dy[] = {0,0,-1,1};
	
	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}

        int year = 0;
        while (true) {
            boolean[][] visited = new boolean[n][m];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        dfs(i, j, visited);
                        cnt++;
                    }
                }
            }
            if (cnt == 0) {
                System.out.println(0);
                break;
            } else if (cnt >= 2) {
                System.out.println(year);
                break;
            }

            year++;
            int[][] nextMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                nextMap[i] = map[i].clone();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (map[nx][ny] <= 0) {
                            nextMap[i][j]--;
                        }
                    }   
                }
            }

            map = nextMap;

        }
	}

    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
 
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
 
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
 
            if (map[nx][ny] > 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }
}
