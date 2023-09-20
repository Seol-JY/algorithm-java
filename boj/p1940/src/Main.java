import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #1940 주몽
    url : https://www.acmicpc.net/problem/1940
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        arr.sort(null);

        int result = 0;

        int p = 0;
        int q = n - 1;
        while (p < q) {
            int sum = arr.get(p) + arr.get(q);
            if (sum == m) {
                result++;
                p++;
                q--;
            } else if (sum > m) {
                q--;
            } else {
                p++;
            }
        }
        bw.append(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
