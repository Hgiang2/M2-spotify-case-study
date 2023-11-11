package menu.service.userCommand.signInCommand;

import constant.Constants;
import menu.menuCommand.CommandInput;

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
        this.username = Constants.SCANNER.next();
    }

    @Override
    public String getInput() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
