package menu.template;

import constant.Constants;
import menu.features.registerArtist.CommandInputStageName;
import menu.features.userCommand.signInCommand.CommandInputUsername;

import java.util.Scanner;

public class NavigateEnterStageName implements Navigator{
    private Scanner SCANNER = new Scanner(System.in);
    private void displayMenuEnterStageName() {
        Menu menu = new MenuInputTemplate("Register as Artist","Register to upload your songs on Spotify");
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandInputStageName()));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayMenuEnterStageName();
    }
}
