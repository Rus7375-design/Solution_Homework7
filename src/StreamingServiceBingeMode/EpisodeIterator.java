package StreamingServiceBingeMode;

import StreamingServiceBingeMode.Episode;

public interface EpisodeIterator {
    boolean hasNext();
    Episode next();
}
