import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class PerformanceTest {
    public static void main(String[] args) {
        List<Episode> episodes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            episodes.add(new Episode("Episode " + i, random.nextInt(3600)));
        }

        Season season = new Season();
        for (Episode episode : episodes) {
            season.addEpisode(episode);
        }

        long start = System.nanoTime();
        Iterator<Episode> iterator = season.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.nanoTime();
        System.out.println("Normal iterator time: " + (end - start) + " ns");

        start = System.nanoTime();
        EpisodeIterator shuffleIterator = season.createShuffleIterator();
        while (shuffleIterator.hasNext()) {
            shuffleIterator.next();
        }
        end = System.nanoTime();
        System.out.println("Shuffle iterator time: " + (end - start) + " ns");
    }
}
