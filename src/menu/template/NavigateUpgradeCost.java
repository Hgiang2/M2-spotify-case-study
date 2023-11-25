package menu.template;

import constant.Constants;
import menu.features.checkPlan.CommandContinuePayment;
import menu.features.exitCommand.CommandBack;

public class NavigateUpgradeCost implements Navigator{
    private void displayCost() {
        Menu menu = new MenuTabTemplate("Cost", "The Premium Plan is " + Constants.PRICE_MONTHLY + "VND per month. Wanna continue?");
        menu.addMenuItem(new MenuItem(Constants.CONTINUE, new CommandContinuePayment()));
        menu.addMenuItem(new MenuItem(Constants.CANCEL, new CommandBack(new NavigateCheckPlanNormal())));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayCost();
    }
}
