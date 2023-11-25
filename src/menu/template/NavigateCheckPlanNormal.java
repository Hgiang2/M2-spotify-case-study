package menu.template;

import constant.Constants;
import menu.features.checkPlan.CommandNavigatePremiumCost;
import menu.features.exitCommand.CommandBack;

public class NavigateCheckPlanNormal implements Navigator{
    private void displayCheckPlanNormal() {
        Menu menu = new MenuTabTemplate("Normal Plan", "You are currently a free user. Do you want to subscribe to Premium Plan?");
        menu.addMenuItem(new MenuItem(Constants.YES, new CommandNavigatePremiumCost()));
        menu.addMenuItem(new MenuItem(Constants.NO, new CommandBack(new NavigateMenuNormalMain())));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayCheckPlanNormal();
    }
}
