package menu.template;

import entity.CurrentEmail;
import entity.Email;
import entity.Request;
import menu.features.selectRequest.CommandSelectRequest;

public class NavigateGmailMenu implements Navigator{
    private void displayGmailMenu() {
        Email email = CurrentEmail.getInstance().getCurrentEmail();
        Menu menu = new MenuTemplate("Gmail", "You have " + "(" + email.getRequestList().size() + ") mail!");
        for (Request request : email.getRequestList()) {
            menu.addMenuItem(new MenuItem(request.getGmailNoti(), new CommandSelectRequest(request)));
        }
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayGmailMenu();
    }
}
