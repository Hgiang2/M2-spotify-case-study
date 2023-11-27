package menu.features.checkPlan.inputMonth;

import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.Command;
import menu.features.CommandInput;

public class CommandInputMonthProcess implements Command {
    @Override
    public void execute() {
        HandlerInputMonth handlerNavigate = new HandlerNavigateTotalPayment(null);
        HandlerInputMonth handlerFormat = new HandlerCheckFormat(handlerNavigate);

        CommandInput inputMonth = new CommandInputMultipleInt("How many months do you want to purchase? ");
        inputMonth.execute();
        String input = inputMonth.getInput();
        handlerFormat.handle(input);
    }
}
