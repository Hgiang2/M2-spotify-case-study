package menu.features.userCommand.signInCommand;

import constant.Constants;
import menu.features.CommandInput;

import java.util.Scanner;

public class CommandInputUsername implements CommandInput {
    private String description;
    private String username;

    public CommandInputUsername(String description) {
        this.description = description;
        this.username = Constants.BLANK;
    }

    @Override
    public void execute() {
        System.out.print(description);
        Scanner SCANNER = new Scanner(System.in);
        this.username = SCANNER.nextLine();
//        SCANNER.close();
    }

    @Override
    public String getInput() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
