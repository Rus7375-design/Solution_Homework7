import java.util.Iterator;
import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private final Iterator<Season> seasonIterator;
    private Iterator<Episode> episodeIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasonIterator = seasons.iterator();
        this.episodeIterator = seasonIterator.hasNext() ? seasonIterator.next().iterator() : null;
    }

    @Override
    public boolean hasNext() {
        while (episodeIterator != null && !episodeIterator.hasNext()) {
            if (seasonIterator.hasNext()) {
                episodeIterator = seasonIterator.next().iterator();
            } else {
                episodeIterator = null;
            }
        }
        return episodeIterator != null && episodeIterator.hasNext();
    }

    @Override
    public Episode next() {
        if (hasNext()) {
            return episodeIterator.next();
        }
        throw new IllegalStateException("No more episodes");
    }
}
