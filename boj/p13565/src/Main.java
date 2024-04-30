import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #13565 침투
    url : https://www.acmicpc.net/problem/13565
*/

public class Main {
    static int m, n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            if(arr[0][i] == 0 && !visited[0][i]) {
                dfs(0, i);
            }
        }

        System.out.println("NO");

    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        if(i == m - 1) {
            System.out.println("YES");
            System.exit(0);
        }

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || arr[x][y] == 1) continue;
            dfs(x, y);
        }

    }
}
