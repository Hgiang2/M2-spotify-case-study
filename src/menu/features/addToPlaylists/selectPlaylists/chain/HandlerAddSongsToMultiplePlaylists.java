package menu.features.addToPlaylists.selectPlaylists.chain;

import entity.Playlist;
import menu.features.addToPlaylists.selectPlaylists.HandleChooseMultipleItems;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.SongInPlaylistManagement;

import java.util.List;

public class HandlerAddSongsToMultiplePlaylists implements HandleChooseMultipleItems {
    private HandleChooseMultipleItems next;

    public HandlerAddSongsToMultiplePlaylists(HandleChooseMultipleItems next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SelectedItems selectedItems) {
        List<Playlist> selectedPlaylists = selectedItems.getSelectedPlaylist();

        for (Playlist playlist : selectedPlaylists) {
            new SongInPlaylistManagement(playlist).addSongs(selectedItems.getSelectedSong());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (selectedItems.getSelectedSong().size() == 1) {
            if (selectedPlaylists.size() == 1) System.out.println(selectedItems.getSelectedSong().get(0).toString() + " added to " + selectedPlaylists.get(0).getName() + " successfully!");
            else System.out.println(selectedItems.getSelectedSong().get(0).toString() + " added to Multiple Playlists successfully!");
        } else {
            if (selectedPlaylists.size() == 1) System.out.println("Songs added to " + selectedPlaylists.get(0).getName() + " successfully!");
            else System.out.println("Songs add to Multiple Playlists successfully!");
        }
        return true;
    }

    @Override
    public void handle(SelectedItems selectedItems) {
        if (!doHandle(selectedItems)) {
            return;
        }
        if (next != null) {
            next.handle(selectedItems);
        }
    }
}
