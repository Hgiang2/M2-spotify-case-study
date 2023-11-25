package menu.features.removeMultiple.chain;

import entity.Song;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllPlaylistsListManagement;
import services.AllSongListManagement;
import services.observer.Observer;
import services.observer.Subject;

public class HandlerRemoveMultipleFromPlaylist extends Subject implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;

    public HandlerRemoveMultipleFromPlaylist(HandleChooseMultipleSong next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        Observer observeAllPlaylist = AllPlaylistsListManagement.getInstance();
        addObserver(observeAllPlaylist);
        for (int i = 0; i < selectedItems.getSelectedSong().size(); i++) {
            listManagement.getSongs().remove(selectedItems.getSelectedSong().get(i));
        }
        notifyObserver();
        removeAll();
        System.out.println("Remove songs from " + listManagement.getTitle() + "successfully!");
        return true;
    }

    @Override
    public void handle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        if (!doHandle(listManagement, selectedItems)) {
            return;
        }
        if (next != null) {
            next.handle(listManagement, selectedItems);
        }
    }
}
