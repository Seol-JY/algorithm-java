import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;
/*
    solved BAEKJOON #9466 텀 프로젝트
    url : https://www.acmicpc.net/problem/9466
*/

public class p9466 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int count = 0;
    static int want[];
    static boolean visited[], done[];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n+1];
            done = new boolean[n+1];
            want = new int[n+1];
            count = 0;
            
            st= new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                want[j] = Integer.parseInt(st.nextToken());
                if (j == want[j]) {
                    count++;
                    done[j] = true;
                }
            }

            for (int j = 1; j <= n; j++) {
                if (!done[j]) {
                    dfs(j);
                }
            }
            System.out.println(n - count);
        }
    }

    protected static void dfs(int idx) {
        if (visited[idx]) {
            return;
        }

        visited[idx] = true;
        int next = want[idx];
        if (!visited[next]) {
            dfs(next);
        } else if (!done[next]) {
            for (int i = next; i != idx; i = want[i]) {
                count++;
            }
            count++;
        }
        done[idx] = true;
    }

}
