import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
    solved BAEKJOON #20920 영단어 암기는 괴로워
    url : https://www.acmicpc.net/problem/20920
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String word = br.readLine();
            if(word.length() < m) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet().stream().collect(Collectors.toList()));

        words.sort((s1, s2) -> {
            int s1Cnt = map.get(s1);
            int s2Cnt = map.get(s2);

            // 자주 나오는 단어일수록 앞에 배치
            if (s1Cnt != s2Cnt) return s2Cnt - s1Cnt;

            // 해당 단어의 길이가 길 수록
            if (s1.length() != s2.length()) return s2.length() - s1.length();

            // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
            return s1.compareTo(s2);
        });

        for(String word: words){
            bw.append(word).append("\n");
        }

        bw.flush();
        bw.close();
    }
}
