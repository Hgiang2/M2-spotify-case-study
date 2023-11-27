package menu.features.addLocalSongsToPlaylist.chain;

import menu.features.addLocalSongsToPlaylist.CommandAddLocalSongsToPlaylistProcess;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.Command;
import menu.template.Navigator;
import services.AllSongListManagement;
import services.AllSongsListManagement;

public class HandlerCheckChoiceInLocalSong implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;
    private Navigator navigateBack;

    public HandlerCheckChoiceInLocalSong(HandleChooseMultipleSong next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        String[] choices = selectedItems.getChoice().split(" ");
        for (String choice : choices) {
            selectedItems.getChoiceList().add(Integer.parseInt(choice));
        }
        for (Integer choice : selectedItems.getChoiceList()) {
            if (choice < 0 || choice > AllSongsListManagement.getInstance().getSongs().size() - 1) return false;
        }
        return true;
    }

    @Override
    public void handle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        if (!this.doHandle(listManagement, selectedItems)) {
            System.out.println("Numbers out of bound!");
            Command choiceReEnter = new CommandAddLocalSongsToPlaylistProcess(listManagement, navigateBack);
            choiceReEnter.execute();
        }
        if (next != null) {
            next.handle(listManagement, selectedItems);
        }
    }
}
