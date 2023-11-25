package menu.features.createPlaylist;

import entity.Playlist;

public interface HandlePlaylist {
    boolean doHandle(Playlist playlist);
    void handle(Playlist playlist);
}
