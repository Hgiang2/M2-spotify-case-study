package menu.features.download.chain;

import entity.Song;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllSongListManagement;
import services.AllSongsListManagement;
import services.observer.Observer;
import services.observer.Subject;
import services.validator.ValidateCheckSongExistInList;
import services.validator.Validator;

public class HandlerCheckExisted extends Subject implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;

    public HandlerCheckExisted(HandleChooseMultipleSong next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        Observer observeAllSongs = AllSongsListManagement.getInstance();
        addObserver(observeAllSongs);
        for (Song song : selectedItems.getSelectedSong()) {
            Validator validator = new ValidateCheckSongExistInList(song, AllSongsListManagement.getInstance().getSongs());
            if (!validator.isCheck()) {
                AllSongsListManagement.getInstance().getSongs().add(song);
                song.setTime(System.currentTimeMillis());
            }
        }
        System.out.println("Download to local library successfully!");
        notifyObserver();
        removeAll();
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
