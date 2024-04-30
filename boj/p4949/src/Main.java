import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #4949 균형잡힌 세상
    url : https://www.acmicpc.net/problem/4949
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;

        while(true) {
            s = br.readLine();
            if(s.equals(".")) {
                break;
            }
            sb.append(solve(s)).append('\n');
        }

        bw.write(sb+"\n");
        bw.flush();
        bw.close();
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {

                case '(':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.peek() != '(') {
                        return "no";
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.empty() || stack.peek() != '[') {
                        return "no";
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }

        if (stack.empty()) {
            return "yes";
        }
        else {
            return "no";
        }
    }
}