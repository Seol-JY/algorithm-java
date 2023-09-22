import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #1806 부분합
    url : https://www.acmicpc.net/problem/1806
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.add(0);

        int p = 0;
        int q = 0;
        Integer cumul = 0;
        int cnt;
        int minCnt = Integer.MAX_VALUE;

        while(q <= N) {
            if (cumul >= S) {
                cumul -= arr.get(p);
                p++;
                cnt = q - p + 1;
                if(minCnt > cnt) minCnt = cnt;

            } else if (cumul < S) {
                cumul += arr.get(q);
                q++;
            }
        }

        if (minCnt == Integer.MAX_VALUE) minCnt = 0;
        bw.append(String.valueOf(minCnt)).append("\n");
        bw.flush();
    }
}
