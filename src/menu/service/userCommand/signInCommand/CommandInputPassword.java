package menu.service.userCommand.signInCommand;

import constant.Constants;
import menu.menuCommand.CommandInput;

public class CommandInputPassword implements CommandInput {
    private String description;
    private String password;

    public CommandInputPassword(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.print(description);
        this.password = Constants.SCANNER.next();
    }

    @Override
    public String getInput() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
