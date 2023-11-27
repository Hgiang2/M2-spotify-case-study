package menu.features.addToPlaylists.selectPlaylists.chain;

import menu.features.Command;
import menu.template.Navigator;
import menu.features.addToPlaylists.selectPlaylists.CommandSelectMultiplePlaylistProcess;
import menu.features.addToPlaylists.selectPlaylists.HandleChooseMultipleItems;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllPlaylistsListManagement;

public class HandlerCheckChoice implements HandleChooseMultipleItems {
    private HandleChooseMultipleItems next;
    private Navigator navigateBack;

    public HandlerCheckChoice(HandleChooseMultipleItems next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(SelectedItems selectedItems) {
        String[] choices = selectedItems.getChoice().split(" ");
        for (String singleChoice : choices) {
            selectedItems.getChoiceList().add(Integer.parseInt(singleChoice));
        }
        for (Integer singleChoice : selectedItems.getChoiceList()) {
            if (singleChoice < 1 || singleChoice > AllPlaylistsListManagement.getInstance().getAllPlaylists().size() - 1) return false;
        }
        return true;
    }

    @Override
    public void handle(SelectedItems selectedItems) {
        if (!this.doHandle(selectedItems)) {
            System.out.println("Numbers out of bound!");
            Command choiceReEnter = new CommandSelectMultiplePlaylistProcess(selectedItems, navigateBack);
            choiceReEnter.execute();
        }
        if (next != null) {
            next.handle(selectedItems);
        }
    }
}
