import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
    solved BAEKJOON #10825 국영수
    url : https://www.acmicpc.net/problem/10825
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer stl = new StringTokenizer(br.readLine());
            map.put(stl.nextToken(),
                    new ArrayList<>(List.of(Integer.parseInt(stl.nextToken()), Integer.parseInt(stl.nextToken()), Integer.parseInt(stl.nextToken()))));
        }

        List<String> students = new ArrayList<>(map.keySet().stream().collect(Collectors.toList()));


        students.sort((s1, s2) -> {
            ArrayList<Integer> s1Score = map.get(s1);
            ArrayList<Integer> s2Score = map.get(s2);

            // 국어 점수가 감소하는 순서로
            if (s1Score.get(0) != s2Score.get(0)) return s2Score.get(0) - s1Score.get(0);

            // 국어 점수가 같으면 영어 점수가 증가하는 순서로
            if (s1Score.get(1) != s2Score.get(1)) return s1Score.get(1) - s2Score.get(1);

            // 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
            if (s1Score.get(2) != s2Score.get(2)) return s2Score.get(2) - s1Score.get(2);

            return s1.compareTo(s2);
        });

        for(String student: students){
            bw.append(student).append("\n");
        }

        bw.flush();
        bw.close();
    }
}
