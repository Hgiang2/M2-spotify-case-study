package menu.features.userCommand.signInCommand;

import menu.template.CommandInput;

import java.util.Scanner;

public class CommandInputPassword implements CommandInput {
    private String description;
    private String password;

    public CommandInputPassword(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.print(description);
        Scanner SCANNER = new Scanner(System.in);
        this.password = SCANNER.next();
//        SCANNER.close();
    }

    @Override
    public String getInput() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
