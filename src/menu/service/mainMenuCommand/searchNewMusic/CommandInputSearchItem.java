package menu.service.mainMenuCommand.searchNewMusic;

import constant.Constants;
import menu.menuCommand.CommandInput;

public class CommandInputSearchItem implements CommandInput {
    private String description;
    private String searchItem;

    public CommandInputSearchItem(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.print(description);
        this.searchItem = Constants.SCANNER.next();
    }

    @Override
    public String getInput() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }
}
