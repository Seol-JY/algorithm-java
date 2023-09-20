import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #2805 나무 자르기
    url : https://www.acmicpc.net/problem/2805
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long N = Long.parseLong(st.nextToken());
        Long M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Long> arr= new ArrayList<>();

        Long max = 0l;
        for (int i = 0; i < N; i++) {
            Long tmp = Long.parseLong(st.nextToken());
            if (tmp > max) max = tmp;
            arr.add(tmp);
        }

        Long min = 0l;
        Long mid = 0l;

        while (min < max) {
            mid = (min + max) / 2;

            Long cnt = 0l;
            for (Long val : arr) {
                cnt += (val - mid <= 0) ? 0 : val - mid;
            }

            if (cnt < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        bw.append(String.valueOf(min - 1)).append("\n");
        bw.flush();
    }
}
