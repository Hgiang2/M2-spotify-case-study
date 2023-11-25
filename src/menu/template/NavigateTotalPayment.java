package menu.template;

import constant.Constants;
import entity.CurrentUser;
import menu.features.exitCommand.CommandBack;
import menu.features.makePayment.CommandMakePayment;

public class NavigateTotalPayment implements Navigator{
    private int monthCount;

    public NavigateTotalPayment(int monthCount) {
        this.monthCount = monthCount;
    }

    private void displayTotalCost() {
        Menu menu = new MenuTabTemplate("Total cost", "The total cost is " + Constants.PRICE_MONTHLY * monthCount + "VND. Proceed to make payment?");
        menu.addMenuItem(new MenuItem(Constants.CONTINUE, new CommandMakePayment(monthCount)));
        if (CurrentUser.getInstance().getCurrentUser().getPlan().isSubscribe()) {
            menu.addMenuItem(new MenuItem(Constants.CANCEL, new CommandBack(new NavigateCheckPlanPremium())));
        } else {
            menu.addMenuItem(new MenuItem(Constants.CANCEL, new CommandBack(new NavigateCheckPlanNormal())));
        }
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayTotalCost();
    }
}
