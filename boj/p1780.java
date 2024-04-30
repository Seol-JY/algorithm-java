import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #1780 종이의 개수
    url : https://www.acmicpc.net/problem/1780
*/

public class p1780 {
    static final int NULL = -2;
    static int minusCount = 0;
    static int zeroCount = 0;
    static int oneCount = 0;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

		for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());	
			}
		}

        partition(0, 0, n);
 
		System.out.println(minusCount);	
		System.out.println(zeroCount);	
		System.out.println(oneCount);

    }


	private static void partition(int row, int col, int size) {
        switch (isAllSameNumber(row, col, size)) {
            case -1:
                minusCount++;
                return;
            case 0:
                zeroCount++;
                return;
            case 1:
                oneCount++;
                return;
        }

		int newSize = size / 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                partition(row + newSize * i, col + newSize * j, newSize);
            }
        }
	}

    private static int isAllSameNumber(int row, int col, int size) {
        int expected = arr[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (expected != arr[i][j]) {
					return NULL;
				}
			}
		}

        return expected;
    }
}
