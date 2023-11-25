package menu.features.searchCommand.searchNewMusic;

import menu.template.CommandInput;

import java.util.Scanner;

public class CommandInputSearchItem implements CommandInput {
    private String description;
    private String searchItem;

    public CommandInputSearchItem(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.print(description);
        Scanner SCANNER = new Scanner(System.in);
        this.searchItem = SCANNER.next();
//        SCANNER.close();
    }

    @Override
    public String getInput() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }
}
