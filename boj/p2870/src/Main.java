import java.io.*;
import java.util.*;

/*
    solved BAEKJOON #2870 수학숙제
    url : https://www.acmicpc.net/problem/2870
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<String> answer = new ArrayList<>(); // 타입 지정

        for(int i=0; i < n; i++) {
            String content = br.readLine();

            String str = "";
            for (char x : content.toCharArray()) {
                if (Character.isDigit(x)) {
                    str += x;
                } else {
                    if (!str.equals("")) {
                        answer.add(str.replaceFirst("^0+(?!$)", ""));
                        str = "";
                    }
                }
            }

            if (!str.equals("")) {
                answer.add(str.replaceFirst("^0+(?!$)", ""));
            }
        }

        answer.sort((s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();

            return s1.compareTo(s2);
        });

        for(String a: answer){
            bw.append(a).append("\n");
        }

        bw.flush();
        bw.close();
    }
}
