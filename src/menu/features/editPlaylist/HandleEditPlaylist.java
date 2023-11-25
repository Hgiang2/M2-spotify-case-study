package menu.features.editPlaylist;

import entity.Playlist;

public interface HandleEditPlaylist {
    boolean doHandle(String name, Playlist playlist);
    void handle(String name, Playlist playlist);
}
