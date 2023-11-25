package menu.features.checkPlan.inputMonth;

import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.template.Command;
import menu.template.CommandInput;

public class CommandInputMonthProcess implements Command {
    @Override
    public void execute() {
        CommandInput inputMonth = new CommandInputMultipleInt("How many months do you want to upgrade?");
        inputMonth.execute();

        String input = inputMonth.getInput();

    }
}
