package menu.features.checkPlan;

import menu.template.Command;
import menu.template.NavigateUpgradeCost;
import menu.template.Navigator;

public class CommandNavigatePremiumCost implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateUpgradeCost();
        navigator.navigate();
    }
}
