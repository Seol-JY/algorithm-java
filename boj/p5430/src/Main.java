import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #5430 AC
    url : https://www.acmicpc.net/problem/5430
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String commands = br.readLine();
            Integer.parseInt(br.readLine()); // skip
            String rawArr = br.readLine();

            Deque<Integer> deque = new LinkedList<>();
            for (String s : rawArr.substring(1, rawArr.length() - 1).split(","))
                if (!s.equals("")) deque.add(Integer.valueOf(s));

            System.out.println(solve(deque, commands));
        }
    }

    static String solve(Deque<Integer> deque, String commands) {
        boolean reverse = false;

        for (char command : commands.toCharArray()) {
            if (command == 'R')
                reverse = !reverse;

            else {
                if (deque.size() == 0)
                    return "error";

                if (reverse) deque.removeLast();
                else deque.removeFirst();
            }
        }


//        System.out.println(deque.toString());

        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            sb.append(reverse ? deque.removeLast() : deque.removeFirst());
            if (deque.size() != 0) sb.append(',');
            else sb.append(']');
        }

        return sb.toString();
    }
}
