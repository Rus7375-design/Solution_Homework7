package StreamingServiceBingeMode;

import StreamingServiceBingeMode.Episode;
import StreamingServiceBingeMode.EpisodeIterator;
import StreamingServiceBingeMode.ReverseSeasonIterator;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public EpisodeIterator createIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator createReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator createShuffleIterator() {
        return new ShuffleSeasonIterator(episodes);
    }

    @Override
    public Iterator<Episode> iterator() {
        EpisodeIterator customIterator = createIterator();

        return new Iterator<Episode>() {
            @Override
            public boolean hasNext() {
                return customIterator.hasNext();
            }

            @Override
            public Episode next() {
                return customIterator.next();
            }
        };
    }
}
