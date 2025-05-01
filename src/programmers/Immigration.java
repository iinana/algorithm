package programmers;
import java.util.*;

/**
 * 프로그래머스 알고리즘 고득점 Kit - 이분탐색
 * "입국 심사"
 * Level 03
 */
class Immigration {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = times[0], h = (long) times[times.length-1] * n;
        long m = (l + h) / 2;

        while (l < h) {
            long avail_n = 0;
            for (int t : times) {
                avail_n += (m / t);
            }

            if (avail_n >= n) h = m;
            else l = m + 1;
            m = (l + h) / 2;
        }
        return m;
    }
}