package StreamingServiceBingeMode;

import StreamingServiceBingeMode.BingeIterator;
import StreamingServiceBingeMode.EpisodeIterator;
import StreamingServiceBingeMode.Season;

import java.util.ArrayList;
import java.util.List;

public class Series {
    private final List<Season> seasons = new ArrayList<>();

    public void addSeason(Season season) {
        seasons.add(season);
    }

    public EpisodeIterator createBingeIterator() {
        return new BingeIterator(seasons);
    }
}
