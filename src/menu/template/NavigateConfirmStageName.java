package menu.template;

import constant.Constants;
import menu.features.exitCommand.CommandBack;
import menu.features.registerArtist.CommandNewRegisterArtistRequest;

public class NavigateConfirmStageName implements Navigator{
    private String stageName;

    public NavigateConfirmStageName(String stageName) {
        this.stageName = stageName;
    }

    private void displayConfirmMenu() {
        Menu menu = new MenuTabTemplate("Confirm Artist's name", "Your stage name is " + stageName + ". Ready to proceed?");
        menu.addMenuItem(new MenuItem(Constants.CONTINUE, new CommandNewRegisterArtistRequest(stageName)));
        menu.addMenuItem(new MenuItem(Constants.CANCEL, new CommandBack(new NavigateMenuStart())));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayConfirmMenu();
    }
}
