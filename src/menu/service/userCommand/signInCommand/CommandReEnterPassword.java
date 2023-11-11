package menu.service.userCommand.signInCommand;

import constant.Constants;
import menu.menuCommand.CommandInput;

public class CommandReEnterPassword implements CommandInput {
    private String description;
    private String passwordConfirm;

    public CommandReEnterPassword(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.print(description);
        this.passwordConfirm = Constants.SCANNER.next();
    }

    @Override
    public String getInput() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
