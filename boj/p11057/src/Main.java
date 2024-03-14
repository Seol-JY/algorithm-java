import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #11057 오르막 수
    url : https://www.acmicpc.net/problem/11057
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                int partialSum = 0;
                for(int k = 0; k <= j; k++) {
                    partialSum += dp[i - 1][k];
                }

                partialSum %= 10_007;
                dp[i][j] = partialSum;
            }
        }
        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }
        sum %= 10_007;
        
        bw.append(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}

