package menu.template;

import constant.Constants;
import entity.CurrentUser;
import entity.Plan;
import entity.ValidUsersList;
import menu.features.exitCommand.CommandBack;
import services.observer.Observer;
import services.observer.Subject;

public class NavigateMakePayment extends Subject implements Navigator {
    private int monthCount;

    public NavigateMakePayment(int monthCount) {
        this.monthCount = monthCount;
    }

    private void savePlan() {
        Observer observeUsers = ValidUsersList.getInstance();
        addObserver(observeUsers);
        Plan currentPlan = CurrentUser.getInstance().getCurrentUser().getPlan();
        if (CurrentUser.getInstance().getCurrentUser().getRole().equals(Constants.NORMAL_USER)) {
            currentPlan.upgradePremium();
        }
        currentPlan.upgradeMore(monthCount);
        notifyObserver();
        removeAll();
    }

    private void displayMakePayment() {
        System.out.println();
        System.out.println("Deposit " + Constants.PRICE_MONTHLY * monthCount + "VND to Spotify......");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        savePlan();
        Menu menu = new MenuTemplate("Payment completed!", "Payment completed! ");
        menu.addMenuItem(new MenuItem(Constants.RETURN, new CommandBack(new NavigateCheckPlanPremium())));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayMakePayment();
    }
}
