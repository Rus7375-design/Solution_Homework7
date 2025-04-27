import java.util.Iterator;
import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private final List<Season> seasons;
    private int currentSeasonIndex = 0;
    private EpisodeIterator currentSeasonIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            currentSeasonIterator = seasons.get(0).createIterator();
        }
    }

    @Override
    public boolean hasNext() {
        while (currentSeasonIterator != null) {
            if (currentSeasonIterator.hasNext()) {
                return true;
            } else {
                currentSeasonIndex++;
                if (currentSeasonIndex >= seasons.size()) {
                    currentSeasonIterator = null;
                    return false;
                } else {
                    currentSeasonIterator = seasons.get(currentSeasonIndex).createIterator();
                }
            }
        }
        return false;
    }

    @Override
    public Episode next() {
        if (hasNext()) {
            return currentSeasonIterator.next();
        }
        throw new IllegalStateException("Больше никаких эпизодов!");
    }
}
