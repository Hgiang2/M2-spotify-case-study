package menu.features.createPlaylist.chain;

import entity.Playlist;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.createPlaylist.HandlePlaylist;
import services.AllSongListManagement;
import services.SongInPlaylistManagement;
import services.observer.Subject;

public class HandlerAddSelectedSongToPlaylist extends Subject implements HandlePlaylist {
    private HandlePlaylist next;
    private SelectedItems selectedItems;

    public HandlerAddSelectedSongToPlaylist(HandlePlaylist next, SelectedItems selectedItems) {
        this.next = next;
        this.selectedItems = selectedItems;
    }

    @Override
    public boolean doHandle(Playlist playlist) {
        AllSongListManagement playlistSongManagement = new SongInPlaylistManagement(playlist);
        playlistSongManagement.addSongs(selectedItems.getSelectedSong());
        System.out.println("Selected songs added to playlist " + playlist.getName() + " successfully!");
        return true;
    }

    @Override
    public void handle(Playlist playlist) {
        if (!doHandle(playlist)) {
            return;
        }
        if (next != null) {
            next.handle(playlist);
        }
    }
}
