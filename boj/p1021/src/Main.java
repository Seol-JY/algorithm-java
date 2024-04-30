import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
    solved BAEKJOON #1021 회전하는 큐
    url : https://www.acmicpc.net/problem/1021
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++)  deque.offer(i);

        int[] seq = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) seq[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i = 0; i < m; i++) {
            int goal_index = deque.indexOf(seq[i]);
            int half_index;
            
            half_index = deque.size() % 2 == 0 ? deque.size() / 2 - 1 : deque.size() / 2;

            if (goal_index <= half_index) {
                for (int j = 0; j < goal_index; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            else {
                for (int j = 0; j < deque.size() - goal_index; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}
