package menu.template;

import menu.features.gmail.CommandInputEmailGmail;
import menu.features.registerArtist.CommandInputEmail;

public class NavigateGmail implements Navigator{
    private void displayGmail() {
        Menu menu = new MenuInputTemplate("Gmail", "Welcome to Gmail!");
        menu.addMenuItem(new MenuItem("Enter your email address: ", new CommandInputEmailGmail()));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayGmail();
    }
}
