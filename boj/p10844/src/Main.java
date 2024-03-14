import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #10844 쉬운 계단 수
    url : https://www.acmicpc.net/problem/10844
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        dp[1][0] = 0;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
            }
            dp[i][0] = dp[i - 1][1] % 1_000_000_000;
            dp[i][9] = dp[i - 1][8] % 1_000_000_000;
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i]) % 1_000_000_000;
        }

        bw.append(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
