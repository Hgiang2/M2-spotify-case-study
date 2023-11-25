package menu.template;

import constant.Constants;
import menu.features.checkPlan.inputMonth.CommandInputMonthProcess;

public class NavigateContinuePayment implements Navigator {
    private void displayContinuePayment() {
        Menu menu = new MenuInputTemplate("Input months", Constants.BLANK);
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandInputMonthProcess()));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayContinuePayment();
    }
}
