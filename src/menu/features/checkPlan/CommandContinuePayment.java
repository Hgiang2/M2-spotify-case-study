package menu.features.checkPlan;

import menu.template.Command;
import menu.template.NavigateContinuePayment;
import menu.template.Navigator;

public class CommandContinuePayment implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateContinuePayment();
        navigator.navigate();
    }
}
