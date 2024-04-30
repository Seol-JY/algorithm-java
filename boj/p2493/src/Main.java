import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #2493 탑
    url : https://www.acmicpc.net/problem/2493
*/

public class Main {
    public static void main(String[] args) throws IOException {
        class Tower {
            int position;
            int height;

            private Tower(int position, int height) {
                this.position = position;
                this.height = height;
            }

            public boolean isGreaterOrEqualTo(int height) {
                return this.height >= height;
            }

            public int getPosition() {
                return position;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Tower> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int position = 1; position <= n; position++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                Tower tower = stack.peek();
                if (tower.isGreaterOrEqualTo(height)) {
                    sb.append(tower.getPosition()).append(" ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            stack.push(new Tower(position, height));
        }

        System.out.println(sb);
    }
}
