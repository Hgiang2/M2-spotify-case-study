package menu.template;

import entity.Email;
import entity.Request;
import menu.features.selectRequest.CommandSelectRequest;

public class NavigateGmailMenu implements Navigator{
    private void displayGmailMenu() {
        Email email = Email.getInstance();
        Menu menu = new MenuTemplate("Gmail", "You have " + "(" + email.getRequests().size() + ")" + "mail");
        for (Request request : email.getRequests()) {
            menu.addMenuItem(new MenuItem(request.getStatus(), new CommandSelectRequest(request)));
        }
        menu.runMenu();

    }
    @Override
    public void navigate() {
        displayGmailMenu();
    }
}
