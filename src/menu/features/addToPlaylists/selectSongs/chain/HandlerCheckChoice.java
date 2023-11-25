package menu.features.addToPlaylists.selectSongs.chain;

import menu.template.Command;
import menu.template.Navigator;
import menu.features.addToPlaylists.selectSongs.CommandAddToPlaylistsProcess;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllSongListManagement;

public class HandlerCheckChoice implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;
    private Navigator navigateBack;

    public HandlerCheckChoice(HandleChooseMultipleSong next, Navigator navigateBack) {
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
            if (choice < 0 || choice > listManagement.getSongs().size() - 1) return false;
        }
        return true;
    }

    @Override
    public void handle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        if (!this.doHandle(listManagement, selectedItems)) {
            System.out.println("Numbers out of bound!");
            Command choiceReEnter = new CommandAddToPlaylistsProcess(listManagement, navigateBack);
            choiceReEnter.execute();
        }
        if (next != null) {
            next.handle(listManagement, selectedItems);
        }
    }
}
