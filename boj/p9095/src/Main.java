import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #9095 1, 2, 3 더하기
    url : https://www.acmicpc.net/problem/9095
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int j = 4; j <= 11; j++) {
            dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(dp[m])).append("\n");
        }

        bw.flush();
        bw.close();
    }
}
