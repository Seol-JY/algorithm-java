import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #10773 제로
    url : https://www.acmicpc.net/problem/10773
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Long> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            long m = Long.parseLong(br.readLine());
            if (m == 0) stack.pop();
            else stack.push(m);
        }

        long sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
