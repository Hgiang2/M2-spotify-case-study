package services.comparator;

import entity.Favorites;
import entity.Playlist;

import java.util.Comparator;

public class SortPlaylistByDate implements Comparator<Playlist> {
    @Override
    public int compare(Playlist playlist1, Playlist playlist2) {
            long playlist1Time = playlist1.getTime();
            long playlist2Time = playlist2.getTime();
            long favoritesTime = Favorites.getInstance().getTime();
            if (playlist1Time == playlist2Time)
                return 0;
            if (playlist1Time == favoritesTime)
                return -1;
            if (playlist2Time == favoritesTime)
                return 1;
            return Integer.compare((int) playlist1Time, (int) playlist2Time);
    }
}
