package menu.features.deleteMultipleLocalSong.chain;

import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.deleteMultipleLocalSong.CommandDeleteMultipleSongProcess;
import menu.template.Command;
import services.AllSongListManagement;

public class HandlerCheckChoice implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;

    public HandlerCheckChoice(HandleChooseMultipleSong next) {
        this.next = next;
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
            Command choiceReEnter = new CommandDeleteMultipleSongProcess();
            choiceReEnter.execute();
        }
        if (next != null) {
            next.handle(listManagement, selectedItems);
        }
    }
}
