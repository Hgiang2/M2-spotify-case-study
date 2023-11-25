package menu.template;

import constant.Constants;
import entity.CurrentUser;
import menu.features.checkPlan.inputMonth.CommandInputMonthProcess;
import menu.features.exitCommand.CommandBack;

public class NavigateCheckPlanPremium implements Navigator{
    private void displayCheckPlanPremium() {
        Menu menu = new MenuTemplate("Plan Premium", "Your Premium Plan is valid until " + CurrentUser.getInstance().getCurrentUser().getPlan().getDate());
        menu.addMenuItem(new MenuItem("Subscribe more", new CommandInputMonthProcess()));
        menu.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, new CommandBack(new NavigateMenuMain())));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayCheckPlanPremium();
    }
}
