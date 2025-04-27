public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Pilot", 3600));
        season1.addEpisode(new Episode("Episode 2", 3500));
        season1.addEpisode(new Episode("Episode 3", 3400));

        System.out.println("Shuffled order:");
        EpisodeIterator shuffleIterator = season1.createShuffleIterator();
        while (shuffleIterator.hasNext()) {
            Episode episode = shuffleIterator.next();
            System.out.println(episode.getTitle() + " (" + episode.getRuntimeSec() + " sec)");
        }
    }
}
