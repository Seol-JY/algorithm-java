import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #8958 OX퀴즈
    url : https://www.acmicpc.net/problem/8958
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String testCase = br.readLine();

            int score = 0;
            int weight = 0;
            for (int j = 0; j < testCase.length(); j++) {
                if (testCase.charAt(j) == 'O') {
                    score += ++weight;
                } else {
                    weight = 0;
                }
            }
            bw.append(String.valueOf(score)).append("\n");
        }

        bw.flush();
    }
}
