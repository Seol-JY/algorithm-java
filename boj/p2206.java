import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

/*
    solved BAEKJOON #2206 벽 부수고 이동하기
    url : https://www.acmicpc.net/problem/2206
*/

public class p2206 {
	static final int WALL = 1;
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
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				int num = str.charAt(j) - '0';
				if (num == 1) {
					map[i][j] = num;
				}
			}
		}
		System.out.println(bfs());
	}


	public static int bfs() {
		boolean[][][] visited = new boolean[n][m][2];

        Queue<Node> queue = new LinkedList<>();
		queue.add(Node.of(0, 0, 1, false));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.isArrival(n - 1, m - 1)) {
				return node.getDist();
			}

			for (int i = 0; i < 4; i++) {
				int nx = node.getX() + dx[i];
				int ny = node.getY() + dy[i];

				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				
				if(map[nx][ny] == WALL) {
                    if(!node.isDestroyed()){
                        queue.add(Node.of(nx, ny, node.getDist() + 1, true));
                        visited[nx][ny][1] = true;
                    }
				} else {
					if(!node.isDestroyed() && !visited[nx][ny][0]) {
                        queue.add(Node.of(nx, ny, node.getDist() + 1, false));
                        visited[nx][ny][0] = true;

                    }else if(node.destroyed && !visited[nx][ny][1]){ 
                        queue.add(Node.of(nx, ny, node.getDist() + 1, true));
                        visited[nx][ny][1] = true;
                    }
				}
			}


		}

		return -1;
	}

	static class Node {
		int x;
		int y;
		int dist;
		boolean destroyed;

		private Node(int x, int y, int dist, boolean destroyed) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.destroyed = destroyed;
		}

		public static final Node of(int x, int y, int dist, boolean destroyed) {
			return new Node(x, y, dist, destroyed);
		}

		protected boolean isDestroyed() {
			return destroyed;
		}

		protected int getX() {
			return x;
		}

		protected int getY() {
			return y;
		}

		protected boolean isArrival(int compareX, int compareY) {
			return x == compareX  && y == compareY;
		}

		protected int getDist() {
			return dist;
		}
	}
}