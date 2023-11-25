package entity;

import services.AllPlaylistsListManagement;

public class Favorites extends Playlist {
    private static Playlist instance;

    private Favorites() {
        super("Favorites");
    }

    public static Playlist getInstance() {
        try {
            instance = AllPlaylistsListManagement.getInstance().getAllPlaylists().get(0);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            instance = new Favorites();
        }
        return instance;
    }
}
