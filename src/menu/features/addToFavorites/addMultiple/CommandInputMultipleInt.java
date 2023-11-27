package menu.features.addToFavorites.addMultiple;

import menu.features.CommandInput;

import java.util.Scanner;

public class CommandInputMultipleInt implements CommandInput {
    private String description;
    private String choice;

    public CommandInputMultipleInt(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.print(description);
        Scanner SCANNER = new Scanner(System.in);
        choice = SCANNER.nextLine();
    }

    @Override
    public String getInput() {
        return choice;
    }
}
