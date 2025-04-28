package StreamingServiceBingeMode;

import StreamingServiceBingeMode.Episode;
import StreamingServiceBingeMode.EpisodeIterator;

public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Pilot", 3600));
        season1.addEpisode(new Episode("StreamingServiceBingeMode.Episode 2", 3500));

        Season season2 = new Season();
        season2.addEpisode(new Episode("StreamingServiceBingeMode.Season 2 Premiere", 3700));
        season2.addEpisode(new Episode("StreamingServiceBingeMode.Season 2 StreamingServiceBingeMode.Episode 2", 3550));

        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("Приятного просмотра всех эпизодов:");
        EpisodeIterator bingeIterator = series.createBingeIterator();
        while (bingeIterator.hasNext()) {
            Episode episode = bingeIterator.next();
            System.out.println(episode.getTitle() + " (" + episode.getRuntimeSec() + " сек)");
        }
    }
}
