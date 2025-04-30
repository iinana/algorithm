package programmers;
import java.util.*;
import java.util.stream.*;

/**
 * 프로그래머스 알고리즘 고득점 Kit - hash
 * "베스트 앨범"
 * Level 03
 */
class Song implements Comparable<Song> {
    int idx;
    int genr_plays;
    int song_plays;

    Song(int idx, int genr_plays, int song_plays) {
        this.idx = idx;
        this.genr_plays = genr_plays;
        this.song_plays = song_plays;
    }

    @Override
    public int compareTo(Song s) {
        /*
            장르재생: 내림차순
            노래재생: 내림차순
            고유번호: 오름차순
        */
        if (this.genr_plays == s.genr_plays) {
            if (this.song_plays == s.song_plays) {
                return this.idx - s.idx;
            } else return (s.song_plays - this.song_plays);
        } else return (s.genr_plays - this.genr_plays);
    }
}

class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> gen = new HashMap<String, Integer>();
        int num = genres.length;
        for (int i = 0; i < num; i++) {
            gen.put(genres[i], gen.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Song> songs = IntStream.range(0, num)
                .mapToObj(i -> new Song(i, gen.get(genres[i]), plays[i]))
                .sorted()
                .collect(Collectors.toList());

        int i = 0, count = 0;
        int pre = 0;
        while (i < songs.size()) {
            Song s = songs.get(i++);
            if (pre == s.genr_plays) {
                if (count >= 2) songs.remove(--i);
                else count++;
            } else {
                count = 1;
                pre = s.genr_plays;
            }
        }

        return songs.stream()
                .mapToInt(song -> song.idx).toArray(); //idx만 남김
    }
}