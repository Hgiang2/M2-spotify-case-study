package menu.features.addToFavorites.chainAddMultiple;

import menu.template.Command;
import menu.template.Navigator;
import menu.features.addToFavorites.addMultiple.CommandAddToFavoritesProcess;
import menu.features.addToFavorites.addMultiple.HandleAddToFavorites;
import services.AllSongListManagement;

public class HandlerAddMultipleToFavorites implements HandleAddToFavorites {
    private HandleAddToFavorites next;
    private Navigator navigateBack;

    public HandlerAddMultipleToFavorites(HandleAddToFavorites next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }
    @Override
    public boolean doHandle(AllSongListManagement listManagement, String choice) {
        String[] choiceString = choice.split(" ");
        int[] choices = new int[choiceString.length];
        for (int i = 0; i < choiceString.length; i++) {
            choices[i] = Integer.parseInt(choiceString[i]);
            if (choices[i] >= listManagement.getSongs().size() || choices[i] < 0) return false;
        }
        listManagement.addMultipleToFavorites(choices);
        return true;
    }

    @Override
    public void handle(AllSongListManagement listManagement, String choice) {
        boolean isInBound = this.doHandle(listManagement, choice);
        if (!isInBound) {
            System.out.println("Numbers out of bound!");
            Command addToFavoritesProcess = new CommandAddToFavoritesProcess(listManagement, navigateBack);
            addToFavoritesProcess.execute();
        }
        if (next != null) {
            next.handle(listManagement, choice);
        }
    }
}
