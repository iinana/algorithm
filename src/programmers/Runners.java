package programmers;
import java.util.HashMap;

/**
 * 프로그래머스 알고리즘 고득점 Kit - hash
 * "완주하지 못한 선수"
 * Level 01
 */
class Runners {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String p : participant)
            map.put(p, map.getOrDefault(p, 0)+1);
        for (String p : completion) {
            if (map.get(p) == 1) map.remove(p);
            else map.put(p, map.get(p)-1);
        }
        return map.entrySet().iterator().next().getKey();
    }
}
