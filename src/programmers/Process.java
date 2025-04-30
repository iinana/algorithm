package programmers;

import java.util.*;

/**
 * 프로그래머스 알고리즘 고득점 Kit - stack/queue
 * "프로세스"
 * Level 02
 */
class Process {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        int len = priorities.length;
        for (int i = 0; i < len; i++) que.add(priorities[i]);
        len--;
        Arrays.sort(priorities);

        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == priorities[len-answer]) {
                answer++;
                if (location == 0) break;
                location--;
            } else {
                que.add(cur);
                location--;
                if (location < 0)
                    location = que.size() - 1;
            }
        }

        return answer;
    }
}