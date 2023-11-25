package menu.features.userCommand.signInCommand;

import menu.template.CommandInput;

import java.util.Scanner;

public class CommandReEnterPassword implements CommandInput {
    private String description;
    private String passwordConfirm;

    public CommandReEnterPassword(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.print(description);
        Scanner SCANNER = new Scanner(System.in);
        this.passwordConfirm = SCANNER.next();
//        SCANNER.close();
    }

    @Override
    public String getInput() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
