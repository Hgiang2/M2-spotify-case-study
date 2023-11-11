package services.comparator;

import entity.Favorites;
import entity.Playlist;

import java.util.Comparator;

public class SortPlaylistByName implements Comparator<Playlist> {
    @Override
    public int compare(Playlist playlist1, Playlist playlist2) {
        String playlist1Name = playlist1.getName();
        String playlist2Name = playlist2.getName();
        String favoritesName = Favorites.getInstance().getName();
            if (playlist1Name.equals(playlist2Name))
                return 0;
            if (playlist1Name.equals(favoritesName))
                return -1;
            if (playlist2Name.equals(favoritesName))
                return 1;
            return playlist1Name.compareTo(playlist2Name);
        //        return Integer.compare(playlist1.getName().charAt(0), playlist2.getName().charAt(0));
    }
}
