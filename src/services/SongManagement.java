package services;

import entity.Favorites;
import entity.Song;

public class SongManagement implements SongSelectable {
    private Song song;

    public SongManagement(Song song) {
        this.song = song;
    }

    @Override
    public void addToFavorites() {
        Favorites.getInstance().getSongsInPlaylist().add(song);
    }

    @Override
    public void addToPlaylists() {

    }
}
