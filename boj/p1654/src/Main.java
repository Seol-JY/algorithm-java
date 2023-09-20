import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #1654 랜선 자르기
    url : https://www.acmicpc.net/problem/1654
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        ArrayList<Integer> arr = new ArrayList<>();

        long max = 0;

        for (int i = 0; i < K; i++) {
            Integer val = Integer.parseInt(br.readLine());
            if (val > max) max = val;
            arr.add(val);
        }

        long min = 1;
        long mid = 0;

        while (max >= min) {
            mid = (max + min) / 2;
            long sum = 0;

            for (int val : arr) {
                sum +=  val / mid;
            }

            if (sum >= N) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }


        bw.append(String.valueOf(max)).append("\n");
        bw.flush();
    }
}
