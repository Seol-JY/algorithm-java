import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #1874 스택 수열
    url : https://www.acmicpc.net/problem/1874
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Long> stack = new Stack<>();
        long pos = 1L;
        boolean err = false;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            int m = Integer.parseInt(br.readLine());

            for( ; pos <= m ; pos++) {
                stack.push(pos);
                sb.append("+\n");
            }

            if(stack.peek() == m) {
                stack.pop();
                sb.append("-\n");
            } else {
                err = true;
            }
        }

        if(err)
            System.out.println("NO");
        else {
            System.out.println(sb);
        }

    }
}
