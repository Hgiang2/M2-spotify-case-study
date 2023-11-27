package menu.template;

import constant.Constants;
import entity.Request;
import menu.features.exitCommand.CommandBack;

public class NavigateSelectRequest implements Navigator{
    private Request request;

    public NavigateSelectRequest(Request request) {
        this.request = request;
    }
    private void displayRequestMenu() {
        Menu menu = new MenuTemplate("Request Selected", request.getGmailMessage() + "\n");
        menu.addMenuItem(new MenuItem(Constants.RETURN, new CommandBack(new NavigateGmailMenu())));
        menu.runMenu();

    }

    @Override
    public void navigate() {
        displayRequestMenu();
    }
}
