package menu.features.makePayment;

import menu.template.Command;
import menu.template.NavigateMakePayment;
import menu.template.Navigator;

public class CommandMakePayment implements Command {
    private int monthCount;

    public CommandMakePayment(int monthCount) {
        this.monthCount = monthCount;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateMakePayment(monthCount);
        navigator.navigate();
    }
}
